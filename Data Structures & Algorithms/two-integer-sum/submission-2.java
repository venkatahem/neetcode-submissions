class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] sol = {};

        for(int i=0;i<nums.length;i++){
            int numTwo = target - nums[i];

            if(map.keySet().contains(numTwo)){
                sol = new int[] {map.get(numTwo),i};
            }

            map.put(nums[i],i);
        }

        return sol;
    }
}
