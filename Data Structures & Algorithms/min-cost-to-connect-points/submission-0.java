class Solution {
    class Edge {
        int from;
        int to;
        int dist;

        public Edge(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        public String toString() {
            return "FROM: " + this.from + " TO: " + this.to + " Dist: " + this.dist;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] adjMatrix = new int[n][n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            visited[i] = false;
            for (int j = i; j < n; j++) {
                int dist =
                    Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adjMatrix[i][j] = dist;
                adjMatrix[j][i] = dist;
            }
        }

        // System.out.println(Arrays.deepToString(adjMatrix));

        visited[0] = true;
        Queue<Edge> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        int cost = 0;
        addToPQ(adjMatrix, pq, 0, n);
        int edges = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (edges == n - 1) {
                break;
            }

            if (visited[edge.to]) {
                continue;
            }

            edges++;

            cost = cost + edge.dist;
            visited[edge.to] = true;
            addToPQ(adjMatrix, pq, edge.to, n);
        }

        // System.out.println(pq);

        return cost;
    }

    private void addToPQ(int[][] adjMatrix, Queue<Edge> pq, int node, int n) {
        // System.out.println(node);
        for (int i = 0; i < n; i++) {
            pq.offer(new Edge(node, i, adjMatrix[node][i]));
        }

        pq.poll();

        // System.out.println(pq);
    }
}
