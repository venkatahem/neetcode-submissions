class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] smallToLeft = new int[n];
        int[] smallToRight = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                smallToLeft[i] = -1;
            } else {
                smallToLeft[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                smallToRight[i] = n;
            } else {
                smallToRight[i] = stack.peek();
            }

            stack.push(i);
        }

        // [7,1,7,2,2,4]
        // System.out.println(Arrays.toString(smallToLeft));
        // System.out.println(Arrays.toString(smallToRight));
        // [-1, -1, 1, 1, 1, 4]
        // [1, 6, 3, 6, 6, 6]

        int max = 0;

        for (int i = 0; i < n; i++) {
            int width = smallToRight[i] - smallToLeft[i] - 1;
            int height = heights[i];

            // System.out.println("W - " + width + " - H - " + height);

            int area = width * height;

            max = Math.max(max, area);
        }

        return max;
    }
}
