class Solution {
    List<String> sol;
    public List<String> generateParenthesis(int n) {
        sol = new ArrayList<>();

        solve(n, n, new StringBuilder());

        return sol;
    }

    private void solve(int open, int close, StringBuilder sb) {
        if (open == 0 && close == 0) {
            sol.add(sb.toString());
            return;
        }

        if (close == open) {
            sb.append('(');
            solve(open - 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            if (open != 0) {
                sb.append('(');
                solve(open - 1, close, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (close != 0) {
                sb.append(')');
                solve(open, close - 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
