

class LRUCache {

    private class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val, Node next, Node prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    HashMap<Integer, Node> hashmap;
    int capacity;

    // mru = most recently used
    // lru = least recently used
    Node mru;
    Node lru;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashmap = new HashMap<>();
    }

    public int get(int key) {
        if (!hashmap.containsKey(key)) {
            return -1;
        }

        Node node = hashmap.get(key);

        // Getting a node makes it MRU
        moveToMRU(node);

        return node.val;
    }

    public void put(int key, int value) {

        // Key already exists
        if (hashmap.containsKey(key)) {

            Node node = hashmap.get(key);
            node.val = value;

            // Updating it makes it MRU
            moveToMRU(node);

            return;
        }

        // Need to remove LRU
        if (hashmap.size() == capacity) {

            hashmap.remove(lru.key);

            // Only one node
            if (lru == mru) {
                lru = null;
                mru = null;
            } else {
                lru = lru.prev;
                lru.next = null;
            }
        }

        // Create new node
        Node newNode = new Node(key, value, null, null);

        hashmap.put(key, newNode);

        // Empty cache
        if (mru == null) {
            mru = newNode;
            lru = newNode;
        } else {
            // Put new node at MRU
            newNode.next = mru;
            mru.prev = newNode;
            mru = newNode;
        }
    }

    private void moveToMRU(Node node) {

        // Already MRU
        if (node == mru) {
            return;
        }

        // If node is LRU, move LRU pointer
        if (node == lru) {
            lru = node.prev;
            lru.next = null;
        } else {
            // Remove node from middle
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Put node at MRU
        node.prev = null;
        node.next = mru;

        mru.prev = node;
        mru = node;
    }
}