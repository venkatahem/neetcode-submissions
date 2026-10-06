class Solution {
    List<List<Integer>> sol;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        sol = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, 0, 0, new ArrayList<>());
        return sol;
    }

    private void solve(int[] nums, int target, int sum, int index, List<Integer> tempSol) {
        if (sum == target) {
            sol.add(new ArrayList<>(tempSol));
            return;
        }

        if (sum > target || index >= nums.length) {
            return;
        }

        tempSol.add(nums[index]);
        solve(nums, target, sum + nums[index], index + 1, tempSol);
        tempSol.remove(tempSol.size() - 1);
        int nextIndex = index;
        while (nextIndex < nums.length && nums[index] == nums[nextIndex]) {
            nextIndex++;
        }
        solve(nums, target, sum, nextIndex, tempSol);
    }
}
