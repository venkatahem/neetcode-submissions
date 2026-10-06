class MedianFinder {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        int maxHeapSize = this.maxHeap.size();

        if(maxHeapSize == 0 || num <= maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }

        balance(minHeap, maxHeap);
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return ((double) maxHeap.peek() + minHeap.peek()) / 2;
        }

        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return minHeap.peek();
    }

    private void balance(Queue<Integer> minHeap, Queue<Integer> maxHeap) {
        int minHeapSize = this.minHeap.size();
        int maxHeapSize = this.maxHeap.size();

        if(minHeapSize > maxHeapSize+1){
            maxHeap.offer(minHeap.poll());
        }

        if(maxHeapSize > minHeapSize+1){
            minHeap.offer(maxHeap.poll());
        }
    }
}
