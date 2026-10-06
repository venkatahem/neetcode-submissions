class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // prerequisite -> course
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] currentPath = new boolean[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (!visited[course]) {
                if (dfs(graph, visited, currentPath, course)) {
                    return false;
                }
            }
        }

        return true;
    }

    // true = cycle exists
    private boolean dfs(
        List<List<Integer>> graph, boolean[] visited, boolean[] currentPath, int node) {
        visited[node] = true;
        currentPath[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(graph, visited, currentPath, neighbor)) {
                    return true;
                }

            } else if (currentPath[neighbor]) {
                // back edge -> cycle
                return true;
            }
        }

        currentPath[node] = false;

        return false;
    }
}