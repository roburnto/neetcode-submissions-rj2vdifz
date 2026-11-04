class Trie {
    Trie[] children = new Trie[26];
    String word;
    public void insert(String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Trie();
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }
}
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int ROWS = board.length;
        int COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                search(board, r, c, trie);
            }
        }
        return res;
    }

    public void search(char[][] board, int r, int c, Trie node) {
        if (node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        if (r >= board.length || r < 0 || c >= board[0].length || c < 0 || board[r][c] == '*') {
            return;
        }
        char curr = board[r][c];
        Trie current = node.children[curr - 'a'];
        if (current == null) {
            return;
        }
        board[r][c] = '*';
        search(board, r + 1, c, current);
        search(board, r - 1, c, current);
        search(board, r, c + 1, current);
        search(board, r, c - 1, current);
        board[r][c] = curr;
    }
}
