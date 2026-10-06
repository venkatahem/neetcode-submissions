class Solution {
    class ValAndArr {
        double val;
        int[] arr;

        public ValAndArr(double val, int[] arr) {
            this.val = val;
            this.arr = arr;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        Queue<ValAndArr> que = new PriorityQueue<>((a, b) -> Double.compare(b.val, a.val));

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            double dis = Math.sqrt((x * x) + (y * y));

            que.offer(new ValAndArr(dis, new int[] {x, y}));

            if (que.size() > k) {
                que.poll();
            }
        }

        int[][] sol = new int[k][2];

        int i = 0;
        while (!que.isEmpty()) {
            sol[i] = que.poll().arr;
            i++;
        }

        return sol;
    }
}
