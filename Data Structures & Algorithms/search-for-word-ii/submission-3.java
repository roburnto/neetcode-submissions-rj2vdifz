// Let:
//   W = number of words, L = max word length (≤ 10)
//   m x n = board size (≤ 12 x 12)
class Trie {
    Trie[] children = new Trie[26];
    String word; // non-null only at a node where a complete word ends

    // Time: O(word length) per insert, so O(W * L) to build the whole trie
    // Space: O(W * L * 26) worst case (each node holds a 26-slot array)
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

    // Overall time:  O(W * L  +  m * n * 4 * 3^(L-1))
    //   - build the trie, then DFS from every cell
    //   - first step has 4 choices, every later step at most 3 (can't revisit the cell you came
    //   from)
    //   - the trie cuts the DFS off as soon as no word has the current prefix,
    //     so in practice it's far below this bound
    // Overall space: O(W * L * 26) for the trie + O(L) recursion depth
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int ROWS = board.length;
        int COLS = board[0].length;

        // m * n starting cells
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                search(board, r, c, trie);
            }
        }
        return res;
    }

    // Time: O(4 * 3^(L-1)) per starting cell; recursion depth ≤ L
    public void search(char[][] board, int r, int c, Trie node) {
        // A word ends at the cell we just came from: record it once
        if (node.word != null) {
            res.add(node.word);
            node.word = null; // prevents duplicates if found again
        }
        if (r >= board.length || r < 0 || c >= board[0].length || c < 0 || board[r][c] == '*') {
            return;
        }
        char curr = board[r][c];
        Trie current = node.children[curr - 'a'];
        if (current == null) {
            return; // no word has this prefix, so prune
        }
        board[r][c] = '*'; // mark visited in place: O(1) extra space instead of a visited[][]
        search(board, r + 1, c, current);
        search(board, r - 1, c, current);
        search(board, r, c + 1, current);
        search(board, r, c - 1, current);
        board[r][c] = curr; // backtrack
    }
}