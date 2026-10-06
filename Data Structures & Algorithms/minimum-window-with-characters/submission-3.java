class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freqS = new HashMap<>();
        Map<Character, Integer> freqT = new HashMap<>();

        int need = t.length();

        for (char ch : t.toCharArray()) {
            freqT.merge(ch, 1, Integer::sum);
        }

        int n = s.length();

        int front = 0;
        int back = 0;

        int minLength = n + 1;
        int validStart = 0;
        int validEnd = 0; // exclusive

        int have = 0;

        while (back < n) {
            // Expand
            char ch = s.charAt(back);

            if (freqT.containsKey(ch)) {
                freqS.merge(ch, 1, Integer::sum);

                if (freqS.get(ch) <= freqT.get(ch)) {
                    have++;
                }
            }

            back++;

            // Shrink while window is valid
            while (have == need) {
                int len = back - front;

                if (len < minLength) {
                    minLength = len;
                    validStart = front;
                    validEnd = back;
                }

                char left = s.charAt(front);

                if (freqT.containsKey(left)) {
                    freqS.put(left, freqS.get(left) - 1);

                    if (freqS.get(left) < freqT.get(left)) {
                        have--;
                    }
                }

                front++;
            }
        }

        if (minLength == n + 1) {
            return "";
        }

        return s.substring(validStart, validEnd);
    }
}