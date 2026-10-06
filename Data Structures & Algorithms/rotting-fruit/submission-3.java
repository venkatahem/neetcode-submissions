class Solution {
    class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        int sol = -1;
        boolean noRottenFruits = true;
        Queue<Pair> que = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    que.offer(new Pair(i, j));
                }
            }
        }
        

        while (!que.isEmpty()) {
            noRottenFruits = false;
            Queue<Pair> newQue = new ArrayDeque<>();

            sol++;

            while (!que.isEmpty()) {
                Pair temp = que.poll();
                int i = temp.i;
                int j = temp.j;

                // up
                if (i > 0 && grid[i - 1][j] == 1) {
                    newQue.offer(new Pair(i - 1, j));
                    grid[i - 1][j] = grid[i - 1][j] + 1;
                }

                // left
                if (j > 0 && grid[i][j - 1] == 1) {
                    newQue.offer(new Pair(i, j - 1));
                    grid[i][j - 1] = grid[i][j - 1] + 1;
                }

                // right
                if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                    newQue.offer(new Pair(i, j + 1));
                    grid[i][j + 1] = grid[i][j + 1] + 1;
                }

                // down
                if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                    newQue.offer(new Pair(i + 1, j));
                    grid[i + 1][j] = grid[i + 1][j] + 1;
                }
            }
            que = newQue;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return noRottenFruits ? 0 : sol;
    }
}
