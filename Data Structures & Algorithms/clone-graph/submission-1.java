/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Integer, Node> map = new HashMap<>();

        Node currNode = new Node(node.val);

        map.put(1, currNode);

        dfs(node, currNode, map);

        return currNode;
    }

    private void dfs(Node node, Node currNode, Map<Integer, Node> map) {
        if (node == null) {
            return;
        }

        for (Node nextNode : node.neighbors) {
            if (map.containsKey(nextNode.val)) {
                // if (!currNode.neighbors.contains(map.get(nextNode.val))) {
                    currNode.neighbors.add(map.get(nextNode.val));
                // }
                continue;
            }
            Node newNode = new Node(nextNode.val);
            map.put(nextNode.val, newNode);
            currNode.neighbors.add(newNode);
            dfs(nextNode, newNode, map);
        }
    }
}