class WordDictionary {
    class TrieNode {
        Map<Character, TrieNode> map;
        boolean end;

        public TrieNode() {
            this.map = new HashMap<>();
            this.end = false;
        }
    }

    TrieNode root;
    boolean found;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = this.root;

        if (!current.map.containsKey(word.charAt(0))) {
            TrieNode rootChar = new TrieNode();
            current.map.put(word.charAt(0), rootChar);
        }

        current = current.map.get(word.charAt(0));

        for (int i = 1; i < word.length(); i++) {
            if (!current.map.containsKey(word.charAt(i))) {
                TrieNode nextChar = new TrieNode();
                current.map.put(word.charAt(i), nextChar);
            }
            current = current.map.get(word.charAt(i));
        }

        current.end = true;
    }

    public boolean search(String word) {
        this.found = false;

        search(word,this.root,0);

        return this.found;
    }

    private void search(String word, TrieNode root,int index){
        if(index == word.length()){
            if(root.end){
                this.found = true;
            }
            return;
        }

        char ch = word.charAt(index);

        if(ch == '.'){
            for(TrieNode temp: root.map.values()){
                search(word,temp,index+1);
                if(this.found){
                    return;
                }
            }
        }else{
            if(root.map.containsKey(ch)){
                search(word,root.map.get(ch),index+1);
            }
        }
    }
}
