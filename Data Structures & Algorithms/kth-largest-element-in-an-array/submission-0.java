class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> que = new PriorityQueue<>((a,b) -> a - b);

        for(int i=0;i<nums.length;i++){
            
            if(que.size() == k){
                if(que.peek()<=nums[i]){
                    que.offer(nums[i]);
                    que.poll();
                }
            }else{
                que.offer(nums[i]);
            }
        }

        return que.poll();
    }
}
