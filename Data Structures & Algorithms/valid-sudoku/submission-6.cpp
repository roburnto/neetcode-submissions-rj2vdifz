class Solution {
   public:
    bool isValidSudoku(vector<vector<char>>& board) {
        unordered_map<int, unordered_set<char>> rows;
        unordered_map<int, unordered_set<char>> cols;
        unordered_map<int, unordered_set<char>> squares;

        for (int r = 0; r < board.size(); r++) {
            for (int c = 0; c < board[0].size(); c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int square_idx = (r / 3) * 3 + (c / 3);
                if (rows[r].count(board[r][c]) || cols[c].count(board[r][c]) ||
                    squares[square_idx].count(board[r][c])) {
                    return false;
                }
                rows[r].insert(board[r][c]);
                cols[c].insert(board[r][c]);
                squares[square_idx].insert(board[r][c]);
            }
        }
        return true;
    }
};