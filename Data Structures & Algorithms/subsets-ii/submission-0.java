class Solution {
    Set<List<Integer>> sol;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        sol = new HashSet<>();
        Arrays.sort(nums);

        solve(0,new ArrayList<>(),nums);

        return List.copyOf(sol);
    }

    private void solve(int index, List<Integer> tempSol,int[] nums){
        if(index == nums.length){
            sol.add(tempSol);
            return;
        }

        List<Integer> tempSol1 = new ArrayList<>(tempSol);
        tempSol1.add(nums[index]);

        solve(index+1,tempSol1,nums);
        solve(index+1,tempSol,nums);

    }
}
