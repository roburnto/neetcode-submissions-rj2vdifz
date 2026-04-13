class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        # directions to go through the grid
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        max_area = 0
        def dfs(r,c):
            # reaching the edges of the graph or not land
            if(r < 0 or r >= len(grid) or c < 0 or c >= len(grid[0]) or grid[r][c] != 1):
                return 0
            # mark this land as visited
            grid[r][c] = 0
            # initialize the area to be 1
            area = 1
            # running the dfs on the graph until no land is encountered
            for dr,dc in directions:
                area += dfs(r+dr, c+dc)
            # returning the total area
            return area
        
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == 1:
                    max_area = max(max_area, dfs(r,c))
        
        return max_area