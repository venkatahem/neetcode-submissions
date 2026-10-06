class Solution {
    class Pair {
        int i;
        int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        // Multi source bfs - > start dfs from multiple sources i.e., add multiple start points
        // in queue before starting in BFS

        Queue<Pair> que = new ArrayDeque<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    que.offer(new Pair(i, j));
                }
            }
        }

        while (!que.isEmpty()) {
            Pair temp = que.poll();

            int i = temp.i;
            int j = temp.j;

            // up
            if (i > 0 && grid[i - 1][j] == 2147483647) {
                que.offer(new Pair(i - 1, j));
                grid[i - 1][j] = grid[i][j] + 1;
            }

            // left
            if (j > 0 && grid[i][j - 1] == 2147483647) {
                que.offer(new Pair(i, j - 1));
                grid[i][j - 1] = grid[i][j] + 1;
            }

            // right
            if (j < grid[i].length - 1 && grid[i][j + 1] == 2147483647) {
                que.offer(new Pair(i, j + 1));
                grid[i][j + 1] = grid[i][j] + 1;
            }

            // down
            if (i < grid.length - 1 && grid[i + 1][j] == 2147483647) {
                que.offer(new Pair(i + 1, j));
                grid[i + 1][j] = grid[i][j] + 1;
            }
        }
    }
}
