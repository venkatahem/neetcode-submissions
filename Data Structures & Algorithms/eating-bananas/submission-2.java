class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        int n = piles.length;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);
        }

        int front = 1;
        int back = max;

        int min = max;

        while (front <= back) {
            int mid = ((back - front) / 2) + front;
            int time = timeTaken(piles, mid, n);
            // System.out.println("T - " + time + " M - " + mid);
            if (time <= h) {
                min = Math.min(mid, min);
                back = mid - 1;
            } else {
                front = mid + 1;
            }
        }

        return min;
    }

    private int timeTaken(int[] piles, int x, int n) {
        int time = 0;

        for (int i = 0; i < n; i++) {
            time = time + (int) Math.ceil((double) piles[i] / x);
        }

        return time;
    }
}
