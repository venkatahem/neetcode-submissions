class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> fs1 = new HashMap<>();
        Map<Character, Integer> fs2 = new HashMap<>();

        for (Character ch : t.toCharArray()) {
            fs1.merge(ch, 1, Integer::sum);
        }

        int front = 0;
        int back = 0;

        int cnt = 0;

        int minWindowLen = s.length() + 1;

        int minWindowStart = -1;

        int len = t.length();

        while (back < s.length()) {
            char ch = s.charAt(back);
            fs2.merge(ch, 1, Integer::sum);

            if (fs1.containsKey(ch) && fs2.get(ch) <= fs1.get(ch)) {
                cnt++;
            }

            while (cnt == len) {
                int currentWinLen = back - front + 1;

                if (currentWinLen < minWindowLen) {
                    minWindowStart = front;
                    minWindowLen = currentWinLen;
                }

                char ch1 = s.charAt(front);

                if (fs1.containsKey(ch1) && fs2.get(ch1) <= fs1.get(ch1)) {
                    cnt--;
                }
                fs2.computeIfPresent(ch1, (key, val) -> val - 1);
                if (fs2.get(ch1) == 0) {
                    fs2.remove(ch1);
                }
                front++;
            }

            back++;
        }

        return minWindowStart == -1 ? ""
                                    : s.substring(minWindowStart, minWindowStart + minWindowLen);
    }
}
