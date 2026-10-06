class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> ele = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for(int i = 0; i < nums.length; i++){
            freqMap.merge(nums[i], 1, Integer::sum);
        }

        for(Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            ele.offer(entry);
            if(ele.size() > k){
                ele.poll();
            }
        }

        int[] sol = new int[k];
        
        for(int i=0; i < k; i++){
            sol[i] = ele.poll().getKey();
        }

        return sol;
    }
}
