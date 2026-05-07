class Solution {
   public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int ROWS = grid.size();
        int COLS = grid[0].size();
        int maxArea = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    maxArea = max(maxArea, dfs(grid, r, c));
                }
            }
        }
        return maxArea;
    }

   private:
    int dfs(vector<vector<int>>& grid, int r, int c) {
        int ROWS = grid.size();
        int COLS = grid[0].size();
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        return 1 + dfs(grid, r + 1, c) + dfs(grid, r - 1, c) + dfs(grid, r, c + 1) +
               dfs(grid, r, c - 1);
    }
};
