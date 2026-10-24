class Solution {
    class Node {
        int x;
        int y;
        int elevation;

        public Node(int x, int y, int elevation) {
            this.x = x;
            this.y = y;
            this.elevation = elevation;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.elevation - b.elevation);
        boolean[][] visited = new boolean[n][n];

        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }

        visited[0][0] = true;
        addNeighboursToPQ(pq, grid, visited, 0, 0, grid[0][0], n);

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (curr.x == n - 1 && curr.y == n - 1) {
                return curr.elevation;
            }
            visited[curr.x][curr.y] = true;
            addNeighboursToPQ(pq, grid, visited, curr.x, curr.y, curr.elevation, n);
        }

        return grid[n-1][n-1];
    }

    private void addNeighboursToPQ(
        Queue<Node> pq, int[][] grid, boolean[][] visited, int x, int y, int currentEle, int n) {
        // up
        if (x > 0 && !visited[x - 1][y]) {
            pq.offer(new Node(x - 1, y, Math.max(currentEle, grid[x - 1][y])));
        }

        // right
        if (y < n - 1 && !visited[x][y + 1]) {
            pq.offer(new Node(x, y + 1, Math.max(currentEle, grid[x][y + 1])));
        }

        // left
        if (y > 0 && !visited[x][y - 1]) {
            pq.offer(new Node(x, y - 1, Math.max(currentEle, grid[x][y - 1])));
        }

        // down
        if (x < n - 1 && !visited[x + 1][y]) {
            pq.offer(new Node(x + 1, y, Math.max(currentEle, grid[x + 1][y])));
        }
    }
}
