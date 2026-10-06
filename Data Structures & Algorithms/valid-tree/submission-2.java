class Solution {
    // if there is loop , then not a valid tree
    // dfs for loop detection 
    // if nextNode is visited and not parent , then loop in a undirected graph
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];

        // initialize visited array and graph adjList
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            visited[i] = false;
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int time = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                time++;
                // tree can't be separated as components ?
                if(time > 1){
                    return false;
                }
                boolean cycle = dfs(adjList, visited, i, i);
                if (cycle) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(List<List<Integer>> adjList, boolean[] visited, int currNode, int parent) {
        visited[currNode] = true;

        for (int nextNode : adjList.get(currNode)) {
            if (!visited[nextNode]) {
                boolean cycle = dfs(adjList, visited, nextNode, currNode);
                if (cycle) {
                    return true;
                }
            } else if (parent != nextNode) {
                return true;
            }
        }

        return false;
    }
}
