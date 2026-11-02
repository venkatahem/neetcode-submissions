class Solution {
    public int climbStairs(int n) {
        // int[] sol = new int[n + 1];

        // Arrays.fill(sol, -1);

        // return solve(n, sol);
        return solve(n);
    }

    // private int solve(int n, int[] sol) {
    //     if (n == 0) {
    //         return 1;
    //     }

    //     if (sol[n] != -1) {
    //         return sol[n];
    //     }

    //     if (n >= 2) {
    //         return sol[n] = solve(n - 2, sol) + solve(n - 1, sol);
    //     } else {
    //         return sol[n] = solve(n - 1, sol);
    //     }
    // }

    private int solve(int n) {
        int[] sol = new int[n + 1];

        sol[0] = 1;

        for (int i = 1; i < n + 1; i++) {
            if (i >= 2) {
                sol[i] = sol[i - 2] + sol[i - 1];
            } else {
                sol[i] = sol[i - 1];
            }
        }

        return sol[n];
    }
}
