class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int ROWS = grid.size();
        int COLS = grid[0].size();
        int count = 0;
        vector<vector<int>> visit(ROWS, vector<int>(COLS,0));
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c]=='1'){
                    count++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }
private:
    void dfs(vector<vector<char>>& grid, int r, int c){
        int ROWS = grid.size();
        int COLS = grid[0].size();
        if(min(r,c) < 0 || r >= ROWS || c >= COLS|| grid[r][c]=='0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
};
