class Solution {
    class Node {
        int node;
        int weight;
        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public String toString() {
            return "[" + this.node + " , " + this.weight + "]";
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Node>> adjList = new HashMap<>();
        int len = flights.length;

        for (int i = 0; i < len; i++) {
            if (adjList.containsKey(flights[i][0])) {
                adjList.get(flights[i][0]).add(new Node(flights[i][1], flights[i][2]));
            } else {
                List<Node> temp = new ArrayList<>();
                temp.add(new Node(flights[i][1], flights[i][2]));
                adjList.put(flights[i][0], temp);
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(src);
        // System.out.println(adjList);

        for (int i = 0; i <= k; i++) {
            // System.out.println(que);

            if (que.isEmpty()) {
                break;
            }

            int[] prev = dist.clone();

            int size = que.size();
            while (size-- > 0) {
                int curr = que.poll();
                List<Node> nextNodes = adjList.getOrDefault(curr, new ArrayList<>());
                int prev_lev_dist = prev[curr];
                for (Node nextNode : nextNodes) {
                    int new_dist = prev_lev_dist + nextNode.weight;

                    if (new_dist < dist[nextNode.node]) {
                        dist[nextNode.node] = new_dist;
                        que.offer(nextNode.node);
                    }
                }
            }
        }

        // System.out.println(Arrays.toString(dist));

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
