class Solution {
    class Pair {
        int p;
        int s;

        public Pair(int p, int s) {
            this.p = p;
            this.s = s;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        if (n == 0)
            return 0;

        Pair[] des = new Pair[n];

        Queue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.p, a.p));

        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(position[i], speed[i]));
        }

        int front = 0;
        double[] time = new double[n];

        while (!pq.isEmpty()) {
            des[front] = pq.poll();

            time[front] = (double) (target - des[front].p) / des[front].s;

            front++;
        }

        Deque<Double> stack = new ArrayDeque<>();

        stack.push(time[0]);

        for (int next = 1; next < n; next++) {
            if (time[next] > stack.peek()) {
                stack.push(time[next]);
            }
        }

        return stack.size();
    }
}