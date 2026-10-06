class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> que = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < stones.length; i++) {
            que.offer(stones[i]);
        }

        while (que.size() > 1) {
            int x = que.poll();
            int y = que.poll();

            if (x == y) {
                continue;
            }
            que.offer(x - y);
        }

        return que.isEmpty() ? 0 : que.poll();
    }
}
