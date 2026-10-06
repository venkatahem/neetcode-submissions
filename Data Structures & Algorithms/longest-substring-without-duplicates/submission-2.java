class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> uC = new HashSet<>();
        int sol = 0;
        int tempSol = 0;

        int front = 0;
        int back = 0;

        while (back < s.length()) {
            char f = s.charAt(front);
            char b = s.charAt(back);
            if (!uC.contains(b)) {
                uC.add(b);
                back++;
                tempSol++;
            } else {
                while (!uC.isEmpty() && uC.contains(f) && uC.contains(b)) {
                    uC.remove(f);
                    front++;
                    f = s.charAt(front);
                    tempSol--;
                }
            }
            sol = Math.max(sol,tempSol);
        }
        return sol;
    }
}
