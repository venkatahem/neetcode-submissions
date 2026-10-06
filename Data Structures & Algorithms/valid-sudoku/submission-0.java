class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rows = new HashSet<>();
        Set<Character> columns = new HashSet<>();

        List<Set<Character>> squares = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            squares.add(new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int squareIndex = (i / 3) * 3 + (j / 3);
                if (board[i][j] != '.') {
                    if (rows.contains(board[i][j])) {
                        return false;
                    } else {
                        rows.add(board[i][j]);
                    }
                }
                if (board[j][i] != '.') {
                    if (columns.contains(board[j][i])) {
                        return false;
                    } else {
                        columns.add(board[j][i]);
                    }
                }
                if (board[i][j] != '.') {
                    if (squares.get(squareIndex).contains(board[i][j])) {
                        return false;
                    } else {
                        squares.get(squareIndex).add(board[i][j]);
                    }
                }
            }
            rows.clear();
            columns.clear();
        }

        return true;
    }
}
