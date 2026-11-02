class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] sol = new int[n];
        sol[0] = nums[0];
        sol[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            sol[i] = Math.max(sol[i - 1], sol[i - 2] + nums[i]);
        }

        return sol[n - 1];
    }

    /* Memoization */

    // public int rob(int[] nums) {
    //     int n = nums.length;
    //     int[] sol = new int[n + 1];
    //     Arrays.fill(sol, -1);
    //     return solve(nums, sol, n - 1);
    // }

    // private int solve(int[] nums, int[] sol, int n) {
    //     if (n < 0) {
    //         return 0;
    //     }

    //     if (sol[n] != -1) {
    //         return sol[n];
    //     }

    //     return sol[n] = Math.max(nums[n] + solve(nums, sol, n - 2), solve(nums, sol, n - 1));
    // }
}
