class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDeg = new int[numCourses];
        
        // input matrix is not a graph representation
        List<List<Integer>> adjList = new ArrayList<>();

        // initialize adjList and inDeg arr
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
            inDeg[i] = 0;
        }

        // update adjList from input
        for (int[] pre : prerequisites) {
            inDeg[pre[0]]++;
            adjList.get(pre[1]).add(pre[0]);
        }

        // topological sort using BFS / Khan's algo
        Queue<Integer> que = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) {
                que.offer(i);
            }
        }

        int index = 0;
        int[] sol = new int[numCourses];

        while (!que.isEmpty()) {
            int curr = que.poll();
            sol[index++] = curr;

            for (int i : adjList.get(curr)) {
                inDeg[i]--;

                if (inDeg[i] == 0) {
                    que.offer(i);
                }
            }
        }

        // check if indegree is 0 for all, else cycle
        boolean cycle = false;
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] > 0) {
                cycle = true;
                break;
            }
        }

        if (cycle) {
            return new int[0];
        }

        return sol;
    }
}
