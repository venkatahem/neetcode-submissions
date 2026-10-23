class Solution {
    class Node {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        public String toString() {
            return "Node - " + this.node + " -- "
                + "Dist - " + this.dist;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[k] = 0;

        Map<Integer, List<Node>> adjList = new HashMap<>();

        for (int i = 0; i < times.length; i++) {
            int from = times[i][0];
            Node to = new Node(times[i][1], times[i][2]);
            if (adjList.containsKey(from)) {
                adjList.get(from).add(to);
            } else {
                List<Node> temp = new ArrayList<>();
                temp.add(to);
                adjList.put(from, temp);
            }
        }

        // System.out.println(adjList);
        // System.out.println(adjList.get(k));

        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        pq.offer(new Node(k, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            List<Node> nbrs = adjList.getOrDefault(curr.node, new ArrayList<>());

            int curr_dist = curr.dist;

            for (Node nbr : nbrs) {
                int dist_to_nbr = nbr.dist;

                int dist_frm_src = curr_dist + dist_to_nbr;

                if (dist_frm_src < dist[nbr.node]) {
                    dist[nbr.node] = dist_frm_src;
                    pq.offer(new Node(nbr.node, dist_frm_src));
                }
            }
        }

        // System.out.println(Arrays.toString(dist));

        int sol = -1;

        for (int i = 1; i < n + 1; i++) {
            sol = Math.max(sol, dist[i]);
        }

        return sol == Integer.MAX_VALUE ? -1 : sol;
    }
}
