class Solution {
    public int climbStairs(int n) {
        int[] sol = new int[n + 1];

        Arrays.fill(sol, -1);

        return solve(n, sol);
    }

    private int solve(int n, int[] sol) {
        if (n == 0) {
            return 1;
        }

        if (sol[n] != -1) {
            return sol[n];
        }

        if (n >= 2) {
            return sol[n] = solve(n - 2, sol) + solve(n - 1, sol);
        } else {
            return sol[n] = solve(n - 1, sol);
        }
    }
}
