class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] sol = new int[n + 1];
        Arrays.fill(sol, -1);
        return solve(nums, sol, n - 1);
    }

    private int solve(int[] nums, int[] sol, int n) {
        if (n < 0) {
            return 0;
        }

        if (sol[n] != -1) {
            return sol[n];
        }

        return sol[n] = Math.max(nums[n] + solve(nums, sol, n - 2), solve(nums, sol, n - 1));
    }
}
