class Solution {
    List<List<String>> sol;
    public List<List<String>> solveNQueens(int n) {
        sol = new ArrayList<>();
        char[][] currPos = new char[n][n];
        for (char[] row : currPos) {
            Arrays.fill(row, '.');
        }

        solve(n, 0, currPos);

        return sol;
    }

    private void solve(int n, int index, char[][] currPos) {
        if (n == index) {
            List<String> tempSol = new ArrayList<>();
            for (int i = 0; i < currPos.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < currPos[i].length; j++) {
                    sb.append(currPos[i][j]);
                }
                tempSol.add(sb.toString());
            }
            sol.add(new ArrayList<>(tempSol));
        }

        for (int col = 0; col < n; col++) {
            if (!canAttack(n, index, col, currPos)) {
                currPos[index][col] = 'Q';
                solve(n, index + 1, currPos);
                currPos[index][col] = '.';
            }
        }
    }

    private boolean canAttack(int n, int row, int col, char[][] currPos) {
        // up

        int temp = row;

        while (temp > 0) {
            temp--;
            if (currPos[temp][col] == 'Q') {
                return true;
            }
        }

        temp = row;
        int temp1 = col;
        // diag left
        while (temp1 > 0 && temp > 0) {
            temp--;
            temp1--;
            if (currPos[temp][temp1] == 'Q') {
                return true;
            }
        }

        temp = row;
        temp1 = col;
        // diag right
        while (temp1 < n-1 && temp > 0) {
            temp--;
            temp1++;
            if (currPos[temp][temp1] == 'Q') {
                return true;
            }
        }

        return false;
    }
}
