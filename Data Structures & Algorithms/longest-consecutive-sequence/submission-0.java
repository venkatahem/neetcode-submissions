class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }

        int length = 0;

        for(int i=0; i<nums.length; i++){
            int len = 0;
            int num = nums[i];
            if(uniqueNums.contains(nums[i]-1)){
                continue;
            }
            len++;
            while(true){
                num++;
                if(uniqueNums.contains(num)){
                    len++;
                }else{
                    length = Math.max(length,len);
                    break;
                }
            }
        }

        return length;
    }
}
