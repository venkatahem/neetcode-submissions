class KthLargest {

    private Queue<Integer> que = new PriorityQueue<>((a,b) -> b - a);
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i=0;i<nums.length;i++){
            que.offer(nums[i]);
        }
    }
    
    public int add(int val) {
        this.que.offer(val);
        int[] temp = new int[this.k-1];
        for(int i=0;i<k-1;i++){
            temp[i] = this.que.poll();
        }

        int sol = this.que.poll();
        this.que.offer(sol);
        for(int i=0;i<k-1;i++){
            this.que.offer(temp[i]);
        }
        

        return sol;
    }
}
