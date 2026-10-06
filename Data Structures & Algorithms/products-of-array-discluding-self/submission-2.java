class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int front = 0;

        int[] prefixProd = new int[len];
        int[] suffixProd = new int[len];

        int back = len - 1;

        int a = 1;
        int b = 1;

        while (front < len && back >= 0) {
            prefixProd[front] = a;
            suffixProd[back] = b;

            a = a * nums[front];
            b = b * nums[back];

            front++;
            back--;
        }

        int[] sol = new int[len];

        for (int i = 0; i < len; i++) {
            sol[i] = prefixProd[i] * suffixProd[i];
        }

        return sol;
    }
}
