class Solution {

    List<List<Integer>> sol;
    
    public List<List<Integer>> subsets(int[] nums) {

        sol = new ArrayList<>();

        solve(0,new ArrayList<>(),nums);

        return sol;
        
    }

    private void solve(int index,List<Integer> temp,int[] nums){
        if(index == nums.length){
            sol.add(temp);
            return;
        }

        List<Integer> temp1 = new ArrayList<>(temp);
        List<Integer> temp2 = new ArrayList<>(temp);

        temp1.add(nums[index]);

        solve(index+1,temp1,nums);
        solve(index+1,temp2,nums);
    }
}
