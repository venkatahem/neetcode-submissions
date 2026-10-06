class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        int front = 1;
        int back = max;

        int sol = max + 1;

        while (front <= back) {
            int mid = ((back - front) / 2) + front;
            int temp = hours(piles,mid);

            if (temp <= h) {
                sol = Math.min(sol, mid);
                back = mid - 1;
            } else {
                front = mid + 1;
            }
        }

        return sol;
    }

    private int hours(int[] ban, int rate) {
        int hrs = 0;

        for (int i = 0; i < ban.length; i++) {
            hrs = hrs + (int) Math.ceil((double) ban[i] / rate);
        }

        return hrs;
    }
}
