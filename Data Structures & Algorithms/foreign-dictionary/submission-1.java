class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> map = new HashMap<>();

        boolean[] visited = new boolean[26];
        boolean[] currPath = new boolean[26];

        Stack<Character> st = new Stack<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                map.putIfAbsent(ch, new ArrayList<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            char[] letters = compareWords(words[i - 1], words[i]);

            if (letters == null) {
                return "";
            }

            if (letters.length == 0) {
                continue;
            }

            map.get(letters[0]).add(letters[1]);
        }

        for (char ch : map.keySet()) {
            if (!visited[ch - 'a']) {
                if (dfs(map, ch, visited, currPath, st)) {
                    return "";
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }

    private boolean dfs(Map<Character, List<Character>> map, char curr, boolean[] visited,
        boolean[] currPath, Stack<Character> st) {
        visited[curr - 'a'] = true;
        currPath[curr - 'a'] = true;

        for (char nbr : map.get(curr)) {
            if (currPath[nbr - 'a']) {
                return true;
            }

            if (!visited[nbr - 'a']) {
                if (dfs(map, nbr, visited, currPath, st)) {
                    return true;
                }
            }
        }

        currPath[curr - 'a'] = false;
        st.push(curr);

        return false;
    }

    private char[] compareWords(String a, String b) {
        int minLen = Math.min(a.length(), b.length());

        for (int i = 0; i < minLen; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return new char[] {a.charAt(i), b.charAt(i)};
            }
        }

        if (a.length() > b.length()) {
            return null;
        }

        return new char[0];
    }
}