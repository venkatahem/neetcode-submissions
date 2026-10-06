class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] largeToLeft = new int[n];
        int[] largeToRight = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                largeToLeft[i] = -1;
                stack.push(i);
            } else {
                largeToLeft[i] = stack.peek();
            }
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                largeToRight[i] = n;
                stack.push(i);
            } else {
                largeToRight[i] = stack.peek();
            }
        }

        // [0,2,0,3,1,0,1,3,2,1]
        // System.out.println(Arrays.toString(largeToLeft));
        // System.out.println(Arrays.toString(largeToRight));
        // [-1, -1, 1, -1, 3, 3, 3, -1, 7, 7]
        // [3, 3, 3, 10, 7, 7, 7, 10, 10, 10]

        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (largeToRight[i] == n || largeToLeft[i] == -1) {
                continue;
            }

            int minHeight = Math.min(height[largeToRight[i]], height[largeToLeft[i]]);
            int capacity = minHeight - height[i];

            sum = sum + capacity;
        }

        return sum;
    }
}
