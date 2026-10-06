class Solution {
    List<List<String>> sol;
    public List<List<String>> partition(String s) {
        sol = new ArrayList<>();
        solve(s, 0, new ArrayList<>());
        return sol;
    }

    private void solve(String s, int index, List<String> tempSol) {
        if (index == s.length()) {
            sol.add(new ArrayList<>(tempSol));
            return;
        }

        for (int j = index; j < s.length(); j++) {
            String ss = s.substring(index, j + 1);

            if (isPalindrome(ss)) {
                tempSol.add(ss);
                solve(s, j + 1, tempSol);
                tempSol.remove(tempSol.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
