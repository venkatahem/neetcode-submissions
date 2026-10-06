class KthLargest {
    private Queue<Integer> que = new PriorityQueue<>((a, b) -> a - b);
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            this.que.offer(nums[i]);
        }
        while (this.que.size() > this.k) {
            this.que.poll();
        }
    }

    public int add(int val) {
        this.que.offer(val);
        if (que.size() > k) {
            que.poll();
        }

        return this.que.peek();
    }
}
