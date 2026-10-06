class Solution {
    List<List<Integer>> sol;
    public List<List<Integer>> permute(int[] nums) {
        sol = new ArrayList<>();

        solve(new ArrayList<>(), nums);

        return sol;
    }

    private void solve(List<Integer> tempSol, int[] nums) {
        if (tempSol.size() == nums.length) {
            sol.add(tempSol);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>(tempSol);
            if (!temp.contains(nums[i])) {
                temp.add(nums[i]);
                solve(temp, nums);
            }
        }
    }
}
