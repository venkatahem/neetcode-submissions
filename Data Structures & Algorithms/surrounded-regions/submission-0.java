class Solution {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        for (int i = 0; i < c; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[r - 1][i] == 'O') {
                dfs(board, r - 1, i);
            }
        }

        for (int i = 0; i < r; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][c - 1] == 'O') {
                dfs(board, i, c - 1);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        board[i][j] = '#';
        // up
        if (i > 0 && board[i - 1][j] == 'O') {
            dfs(board, i - 1, j);
        }

        // left
        if (j > 0 && board[i][j - 1] == 'O') {
            dfs(board, i, j - 1);
        }

        // right
        if (j < board[i].length - 1 && board[i][j + 1] == 'O') {
            dfs(board, i, j + 1);
        }

        // down
        if (i < board.length - 1 && board[i + 1][j] == 'O') {
            dfs(board, i + 1, j);
        }

        return;
    }
}
