class Solution {
    class TrieNode {
        Map<Character, TrieNode> map;
        boolean end;

        public TrieNode() {
            this.map = new HashMap<>();
            this.end = false;
        }
    }

    TrieNode root;

    List<String> sol;

    public List<String> findWords(char[][] board, String[] words) {
        this.root = new TrieNode();
        this.sol = new ArrayList<>();

        initializeTrie(words);

        boolean[][] included = new boolean[board.length][board[0].length];

        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (root.map.containsKey(board[row][col])) {
                    included[row][col] = true;
                    sb.append(board[row][col]);

                    solve(board, included, root.map.get(board[row][col]), sb, row, col);

                    included[row][col] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }

        return sol;
    }

    private void solve(
        char[][] board, boolean[][] included, TrieNode root, StringBuilder sb, int i, int j) {
        if (root.end) {
            this.sol.add(new String(sb.toString()));
            root.end = false;
        }

        // up
        if (i > 0 && root.map.containsKey(board[i - 1][j]) && !included[i - 1][j]) {
            included[i - 1][j] = true;
            sb.append(board[i - 1][j]);
            solve(board, included, root.map.get(board[i - 1][j]), sb, i - 1, j);
            sb.deleteCharAt(sb.length() - 1);
            included[i - 1][j] = false;
        }
        // left
        if (j > 0 && root.map.containsKey(board[i][j - 1]) && !included[i][j - 1]) {
            included[i][j - 1] = true;
            sb.append(board[i][j - 1]);
            solve(board, included, root.map.get(board[i][j - 1]), sb, i, j - 1);
            sb.deleteCharAt(sb.length() - 1);
            included[i][j - 1] = false;
        }
        // right
        if (j < board[i].length - 1 && root.map.containsKey(board[i][j + 1])
            && !included[i][j + 1]) {
            included[i][j + 1] = true;
            sb.append(board[i][j + 1]);
            solve(board, included, root.map.get(board[i][j + 1]), sb, i, j + 1);
            sb.deleteCharAt(sb.length() - 1);
            included[i][j + 1] = false;
        }
        // down
        if (i < board.length - 1 && root.map.containsKey(board[i + 1][j]) && !included[i + 1][j]) {
            included[i + 1][j] = true;
            sb.append(board[i + 1][j]);
            solve(board, included, root.map.get(board[i + 1][j]), sb, i + 1, j);
            sb.deleteCharAt(sb.length() - 1);
            included[i + 1][j] = false;
        }
        return;
    }

    private void initializeTrie(String[] words) {
        for (String str : words) {
            TrieNode temp = this.root;

            for (Character ch : str.toCharArray()) {
                if (!temp.map.containsKey(ch)) {
                    TrieNode nextChar = new TrieNode();
                    temp.map.put(ch, nextChar);
                }

                temp = temp.map.get(ch);
            }

            temp.end = true;
        }
    }
}
