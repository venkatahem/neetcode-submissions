class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] leftRight = new int[len];
        Arrays.fill(leftRight, 0);

        Deque<Integer> que = new ArrayDeque<>();

        for (int i = 0; i < len; i++) {
            if (leftRight[i] == 0) {
                que.offer(i);
                leftRight[i] = -1;
            }

            while (!que.isEmpty()) {
                int j = que.poll();
                for (Integer neighbour : graph[j]) {
                    if (leftRight[j] == leftRight[neighbour]) {
                        return false;
                    } else if (leftRight[neighbour] == 0) {
                        leftRight[neighbour] = -1 * leftRight[j];
                        que.offer(neighbour);
                    }
                }
            }
        }

        return true;
    }
}
