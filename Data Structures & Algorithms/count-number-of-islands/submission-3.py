class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        ROWS = len(grid)
        COLS = len(grid[0])
        res = 0

        def dfs(ROWS, COLS, r, c, directions):
            if r < 0 or c < 0 or r >= ROWS or c >= COLS or grid[r][c] == "0":
                return
            grid[r][c] = "0"
            for dr, dc in directions:
                dfs(ROWS, COLS, r + dr, c + dc, directions)

        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == "1":
                    res += 1
                    dfs(ROWS, COLS, r, c, directions)

        return res
