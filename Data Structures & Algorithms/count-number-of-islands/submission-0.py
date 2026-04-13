class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        groups = 0 
        # Down, Right, Up, Left
        directions = [
            (1, 0),   # down
            (0, 1),   # right
            (-1, 0),  # up
            (0, -1)   # left
        ]


        def dfs(r, c):
            if (
                r < 0 or r >= len(grid) or
                c < 0 or c >= len(grid[0]) or
                grid[r][c] != '1'
            ):
                return

            grid[r][c] = '0'

            for dr, dc in directions:
                dfs(r + dr, c + dc)

        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c]=='1':
                    groups += 1
                    dfs(r,c)
            
        return groups
