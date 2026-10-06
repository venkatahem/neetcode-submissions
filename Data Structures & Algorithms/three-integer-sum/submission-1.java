class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));
        
        for(int i = 0; i < nums.length; i++){
            List<Integer> temp = new ArrayList<>();
            int target =  nums[i] * -1;
            int front = 0;
            int back = nums.length - 1;
            while(front < back){
                if(front == i){
                    front++;
                }
                if(back == i){
                    back--;
                }
                if(front == back){
                    break;
                }
                if(nums[front] + nums[back] == target){
                    if(i < front && i < back){
                        Collections.addAll(temp,nums[i],nums[front],nums[back]);
                    }else if(i > front && i < back){
                        Collections.addAll(temp,nums[front],nums[i],nums[back]);
                    }else{
                        Collections.addAll(temp,nums[front],nums[back],nums[i]);
                    }
                    if(!sol.contains(temp) && !temp.isEmpty()){
                        sol.add(new ArrayList<>(temp));
                    }
                    temp.clear();
                    front++;
                }else if(nums[front] + nums[back] > target){
                    back--;
                }else{
                    front++;
                }
            }
        }

        return sol;
    }
}
