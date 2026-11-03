class Solution {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (search(board, row, col, word.toCharArray(), 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, int row, int col, char[] word, int index) {
        if (index == word.length) {
            return true;
        }

        if (row < 0 || row == board.length || col < 0 || col == board[0].length
            || board[row][col] != word[index]) {
            return false;
        }

        index++;

        char ch = board[row][col];
        board[row][col] = '*';

        boolean result = search(board, row + 1, col, word, index)
            || search(board, row - 1, col, word, index) || search(board, row, col + 1, word, index)
            || search(board, row, col - 1, word, index);

        board[row][col] = ch;

        return result;
    }
}
