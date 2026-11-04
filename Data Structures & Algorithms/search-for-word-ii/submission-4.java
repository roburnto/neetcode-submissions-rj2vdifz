// Let:
//   W = number of words, L = max word length (≤ 10)
//   m x n = board size (≤ 12 x 12)
class Trie {
    Trie[] children = new Trie[26];
    String word; // non-null only at a node where a complete word ends
    int childCount; // number of non-null children, so a leaf check is O(1)

    // Time: O(word length)
    public void insert(String word) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new Trie();
                curr.childCount++;
            }
            curr = curr.children[c - 'a'];
        }
        curr.word = word;
    }
}

class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int remaining; // words still not found; lets us stop early

    // Time:  O(W*L) to build + O(m*n * 4 * 3^(L-1)) worst case for the DFS
    //        (pruning makes the DFS far cheaper in practice)
    // Space: O(W*L*26) for the trie + O(L) recursion depth
    public List<String> findWords(char[][] board, String[] words) {
        int ROWS = board.length;
        int COLS = board[0].length;
        List<String> res = new ArrayList<>();

        Trie root = new Trie();
        for (String word : words) {
            root.insert(word);
            remaining++;
        }

        for (int r = 0; r < ROWS && remaining > 0; r++) {
            for (int c = 0; c < COLS && remaining > 0; c++) {
                search(board, r, c, root, res);
            }
        }
        return res;
    }

    // DFS from (r, c). `parent` is the trie node for the path BEFORE this cell.
    private void search(char[][] board, int r, int c, Trie parent, List<String> res) {
        char ch = board[r][c];
        Trie node = parent.children[ch - 'a'];
        if (node == null) {
            return; // no remaining word has this prefix
        }

        if (node.word != null) {
            res.add(node.word);
            node.word = null; // prevents duplicates
            remaining--;
        }

        board[r][c] = '*'; // mark visited
        for (int[] d : DIRS) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length
                && board[nr][nc] != '*' && remaining > 0) {
                search(board, nr, nc, node, res);
            }
        }
        board[r][c] = ch; // backtrack

        // This branch can't produce any more words, so cut it out of the trie
        if (node.word == null && node.childCount == 0) {
            parent.children[ch - 'a'] = null;
            parent.childCount--;
        }
    }
}