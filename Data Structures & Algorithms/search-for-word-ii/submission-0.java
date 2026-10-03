class Solution {
    public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;

            // O(L), where L = length of word
            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }

                curr = curr.children[index];
            }

            curr.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        // O(S), where S = total number of characters across all words
        for (String word : words) {
            trie.insert(word);
        }

        List<String> result = new ArrayList<>();

        // O(M * N * 3^L), where:
        // M = rows, N = cols, L = max word length
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, trie.root, result);
            }
        }

        return result;
    }

    public void dfs(char[][] board, int row, int col, TrieNode node, List<String> result) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        char c = board[row][col];

        if (c == '#') {
            return;
        }

        int index = c - 'a';

        if (node.children[index] == null) {
            return;
        }

        node = node.children[index];

        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[row][col] = '#';

        // O(3^L) worst case across the recursive DFS tree
        dfs(board, row + 1, col, node, result);
        dfs(board, row - 1, col, node, result);
        dfs(board, row, col + 1, node, result);
        dfs(board, row, col - 1, node, result);

        board[row][col] = c;
    }
}