class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> adjList = new HashMap<>();

        for (List<String> ticket : tickets) {
            String to = ticket.get(1);
            String from = ticket.get(0);
            if (adjList.containsKey(from)) {
                adjList.get(from).offer(to);
            } else {
                Queue<String> temp = new PriorityQueue<>((a, b) -> a.compareTo(b));
                temp.offer(to);
                adjList.put(from, temp);
            }
        }

        List<String> sol = new ArrayList<>();

        dfs("JFK", adjList, sol);

        return sol;
    }

    private void dfs(String node, Map<String, Queue<String>> adjList, List<String> sol) {
        Queue<String> nextNodes = adjList.get(node);

        while (nextNodes != null && !nextNodes.isEmpty()) {
            String next = nextNodes.poll();
            dfs(next, adjList, sol);
        }

        sol.add(0,node);
        return;
    }
}
