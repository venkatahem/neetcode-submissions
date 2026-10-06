class Solution {
    List<List<Integer>> sol;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        sol = new ArrayList<>();
        solve(nums, target, 0, 0, new ArrayList<>());
        return sol;
    }

    private void solve(int[] nums, int target, int sum, int index, List<Integer> tempSol) {
        if (target == sum) {
            sol.add(new ArrayList<>(tempSol));
            return;
        } else if (sum > target|| index >= nums.length) {
            return;
        }

        tempSol.add(nums[index]);
        solve(nums, target, sum + nums[index], index, tempSol);
        tempSol.remove(tempSol.size() - 1);
        solve(nums, target, sum, index+1, tempSol);
    }
}
