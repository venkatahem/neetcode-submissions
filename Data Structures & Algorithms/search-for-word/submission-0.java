class Solution {
    boolean sol;
    public boolean exist(char[][] board, String word) {
        sol = false;
        boolean[][] included = new boolean[board.length][board[0].length];
        solve(board, word, 0, included, 0, 0);
        return sol;
    }

    private void solve(
        char[][] board, String word, int letterCount, boolean[][] included, int i, int j) {
        if (letterCount == word.length()) {
            sol = true;
            return;
        }

        if (letterCount > 0) {
            // up
            if (i > 0 && board[i - 1][j] == word.charAt(letterCount) && !included[i - 1][j]) {
                included[i - 1][j] = true;
                letterCount++;
                solve(board, word, letterCount, included, i - 1, j);
                letterCount--;
                included[i - 1][j] = false;
            }
            // left
            if (j > 0 && board[i][j - 1] == word.charAt(letterCount) && !included[i][j - 1]) {
                included[i][j - 1] = true;
                letterCount++;
                solve(board, word, letterCount, included, i, j - 1);
                letterCount--;
                included[i][j - 1] = false;
            }
            // right
            if (j < board[i].length - 1 && board[i][j + 1] == word.charAt(letterCount)
                && !included[i][j + 1]) {
                included[i][j + 1] = true;
                letterCount++;
                solve(board, word, letterCount, included, i, j + 1);
                letterCount--;
                included[i][j + 1] = false;
            }
            // down
            if (i < board.length - 1 && board[i + 1][j] == word.charAt(letterCount)
                && !included[i + 1][j]) {
                included[i + 1][j] = true;
                letterCount++;
                solve(board, word, letterCount, included, i + 1, j);
                letterCount--;
                included[i + 1][j] = false;
            }
            return;
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[i].length; col++) {
                if (board[row][col] == word.charAt(letterCount)) {
                    included[row][col] = true;
                    letterCount++;
                    solve(board, word, letterCount, included, row, col);
                    included[row][col] = false;
                    letterCount--;
                }
                if (sol) {
                    break;
                }
            }
            if (sol) {
                break;
            }
        }
    }
}
