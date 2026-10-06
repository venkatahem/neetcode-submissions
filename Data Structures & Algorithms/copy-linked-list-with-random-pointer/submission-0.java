/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Map<Node, Node> nodeMap = new HashMap<>();

        Node dummy = new Node(0);

        Node temp = head;

        Node prev = dummy;

        while (temp != null) {
            Node temp1;
            if (nodeMap.containsKey(temp)) {
                temp1 = nodeMap.get(temp);
                prev.next = temp1;
                // nodeMap.remove(temp);
            } else {
                temp1 = new Node(temp.val);
                nodeMap.put(temp, temp1);
                prev.next = temp1;
            }
            if (temp.random != null) {
                if (nodeMap.containsKey(temp.random)) {
                    temp1.random = nodeMap.get(temp.random);
                } else {
                    Node randomNode = new Node(temp.random.val);
                    temp1.random = randomNode;
                    nodeMap.put(temp.random, randomNode);
                }
            } else {
                temp1.random = null;
            }
            prev = prev.next;
            temp = temp.next;
        }

        return dummy.next;
    }
}
