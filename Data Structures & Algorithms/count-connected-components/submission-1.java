class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];

        // initialize visited array and graph adjList
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            visited[i] = false;
            parent[i] = -1;
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> que = new ArrayDeque<>();

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                que.offer(i);
                parent[i] = i;
                count++;
            }

            while (!que.isEmpty()) {
                int curr = que.poll();

                for (int next : adjList.get(curr)) {
                    if (!visited[next]) {
                        parent[next] = curr;
                        visited[next] = true;
                        que.offer(next);
                    } else if (next != parent[curr]) {
                        // break;
                    }
                }
            }
        }

        return count;
    }
}
