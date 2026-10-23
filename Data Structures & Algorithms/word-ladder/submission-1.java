class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> adjList = new HashMap<>();

        List<String> allWords = new ArrayList<>(wordList);

        if (!allWords.contains(beginWord)) {
            allWords.add(beginWord);
        }

        buildGraph(allWords, adjList);

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(beginWord);
        visited.add(beginWord);

        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(endWord)) {
                    return length;
                }

                for (String nbr : adjList.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(nbr)) {
                        visited.add(nbr);
                        queue.offer(nbr);
                    }
                }
            }

            length++;
        }

        return 0;
    }

    private void buildGraph(
        List<String> words,
        Map<String, List<String>> adjList
    ) {
        for (String word : words) {
            adjList.put(word, new ArrayList<>());
        }

        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {

                String word1 = words.get(i);
                String word2 = words.get(j);

                if (diffByOne(word1, word2)) {
                    adjList.get(word1).add(word2);
                    adjList.get(word2).add(word1);
                }
            }
        }
    }

    private boolean diffByOne(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;

                if (diff > 1) {
                    return false;
                }
            }
        }

        return diff == 1;
    }
}