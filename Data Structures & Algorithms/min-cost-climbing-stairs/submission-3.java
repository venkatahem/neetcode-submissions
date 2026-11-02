class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] sol = new int[n + 1];
        sol[0] = 0;
        sol[1] = 0;

        for (int i = 2; i < n + 1; i++) {
            sol[i] = Math.min(sol[i - 1] + cost[i - 1], sol[i - 2] + cost[i - 2]);
        }

        return sol[n];
    }

    /* Memoization */

    // public int minCostClimbingStairs(int[] cost) {
    //     int n = cost.length;
    //     int[] sol = new int[n + 1];
    //     Arrays.fill(sol, -1);

    //     int temp = solve(cost, sol, 0, cost.length);
    //     int temp1 = solve(cost, sol, 1, cost.length);
    //     int res = Math.min(temp, temp1);

    //     return res;
    // }

    // private int solve(int[] cost, int[] sol, int i, int n) {
    //     if (i >= n) {
    //         return 0;
    //     }

    //     if (sol[i] != -1) {
    //         return sol[i];
    //     }

    //     return sol[i] = Math.min(
    //                cost[i] + solve(cost, sol, i + 1, n), cost[i] + solve(cost, sol, i + 2, n));
    // }

    /* Recursion */

    // public int minCostClimbingStairs(int[] cost) {
    //     int sol = Math.min(solve(cost, 0, cost.length), solve(cost, 1, cost.length));

    //     return sol;
    // }

    // private int solve(int[] cost, int i, int n) {
    //     if (i >= n) {
    //         return 0;
    //     }

    //     return Math.min(cost[i] + solve(cost, i + 1, n), cost[i] + solve(cost, i + 2, n));
    // }
}
