class Solution {
    int sol = 0;
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    solve(grid, i, j);
                    sol++;
                }
            }
        }

        return sol;
    }

    private void solve(char[][] grid, int i, int j) {
        // up
        if (i > 0 && grid[i - 1][j] != '0') {
            grid[i - 1][j] = '0';
            solve(grid, i - 1, j);
        }

        // down
        if (i < grid.length - 1 && grid[i + 1][j] != '0') {
            grid[i + 1][j] = '0';
            solve(grid, i + 1, j);
        }

        // left
        if (j > 0 && grid[i][j - 1] != '0') {
            grid[i][j - 1] = '0';
            solve(grid, i, j - 1);
        }

        // right
        if (j < grid[i].length - 1 && grid[i][j + 1] != '0') {
            grid[i][j + 1] = '0';
            solve(grid, i, j + 1);
        }

        return;
    }
}
