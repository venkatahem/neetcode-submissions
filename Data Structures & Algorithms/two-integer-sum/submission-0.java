class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numsMap = new HashMap<>();
        int[] sol = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];

            if(numsMap.containsKey(diff)){
                sol[0] = numsMap.get(diff);
                sol[1] = i;
                break;
            }else{
                numsMap.put(nums[i],i);
            }
        }

        return sol;
    }
}
