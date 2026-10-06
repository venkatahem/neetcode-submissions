class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        if (n == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();

        int l = 0;
        int r = 0;

        set.add(s.charAt(l));

        int sol = 0;

        while (r < n) {
            sol = Math.max(r - l + 1, sol);

            r++;

            if (r < n) {
                char ch = s.charAt(r);

                while (l < r && set.contains(ch)) {
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(ch);
            }
        }

        return sol;
    }
}
