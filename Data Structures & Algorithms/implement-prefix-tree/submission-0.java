class PrefixTree {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        public TrieNode() {
            this.children = new HashMap<>();
            this.endOfWord = false;
        }
    }

    TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = this.root;

        if (!current.children.keySet().contains(word.charAt(0))) {
            TrieNode temp = new TrieNode();
            current.children.put(word.charAt(0), temp);
        }
        current = current.children.get(word.charAt(0));

        for (int i = 1; i < word.length(); i++) {
            if (!current.children.keySet().contains(word.charAt(i))) {
                TrieNode temp1 = new TrieNode();
                current.children.put(word.charAt(i), temp1);
            }
            current = current.children.get(word.charAt(i));
        }

        current.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = this.root;

        for (int i = 0; i < word.length(); i++) {
            if (current.children.keySet().contains(word.charAt(i))) {
                current = current.children.get(word.charAt(i));
            } else {
                return false;
            }
        }

        if (current.endOfWord) {
            return true;
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            if (current.children.keySet().contains(prefix.charAt(i))) {
                current = current.children.get(prefix.charAt(i));
            } else {
                return false;
            }
        }

        return true;
    }
}
