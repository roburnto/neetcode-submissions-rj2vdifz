class Solution {
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, 0, r, c, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int r, int c, String word) {
        if (i >= word.length()) {
            return true;
        }
        if (r >= board.length || r < 0 || c >= board[0].length || c < 0 || board[r][c] == '0'
            || board[r][c] != word.charAt(i)) {
            return false;
        }
        board[r][c] = '0';
        boolean res = dfs(board, i + 1, r + 1, c, word) || dfs(board, i + 1, r - 1, c, word)
            || dfs(board, i + 1, r, c + 1, word) || dfs(board, i + 1, r, c - 1, word);
        board[r][c] = word.charAt(i);
        return res;
    }
}
