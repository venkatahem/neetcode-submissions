class Solution {
    int sol = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    sol = 0;
                    sol++;
                    grid[i][j] = 0;
                    solve(grid, i, j);
                    res = Math.max(res, sol);
                }
            }
        }

        return res;
    }

    private void solve(int[][] grid, int i, int j) {
        // up
        if (i > 0 && grid[i - 1][j] != 0) {
            grid[i - 1][j] = 0;
            solve(grid, i - 1, j);
            sol++;
        }

        // down
        if (i < grid.length - 1 && grid[i + 1][j] != 0) {
            grid[i + 1][j] = 0;
            solve(grid, i + 1, j);
            sol++;
        }

        // left
        if (j > 0 && grid[i][j - 1] != 0) {
            grid[i][j - 1] = 0;
            solve(grid, i, j - 1);
            sol++;
        }

        // right
        if (j < grid[i].length - 1 && grid[i][j + 1] != 0) {
            grid[i][j + 1] = 0;
            solve(grid, i, j + 1);
            sol++;
        }

        return;
    }
}
