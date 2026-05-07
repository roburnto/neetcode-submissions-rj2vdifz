class Solution {
   public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int ROWS = image.size(), COLS = image[0].size();
        vector<vector<int>> visit(ROWS, vector<int>(COLS, 0));
        dfs(image, sr, sc, visit, color, image[sr][sc]);
        return image;
    }
    // Count paths (backtracking)
    // In C++ it's easier to use a 2D array for visit rather than a hashset.
    void dfs(vector<vector<int>>& grid, int r, int c, vector<vector<int>>& visit, int color,
             int startColor) {
        int ROWS = grid.size(), COLS = grid[0].size();
        if (min(r, c) < 0 || r == ROWS || c == COLS || visit[r][c] || grid[r][c] != startColor) {
            return;
        }
        if (grid[r][c] == startColor) {
            grid[r][c] = color;
        };
        visit[r][c] = 1;
        dfs(grid, r + 1, c, visit, color, startColor);
        dfs(grid, r - 1, c, visit, color, startColor);
        dfs(grid, r, c + 1, visit, color, startColor);
        dfs(grid, r, c - 1, visit, color, startColor);
    }
};