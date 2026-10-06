class Solution {
    public int trap(int[] height) {
        int[] left = nextLargerLeft(height);
        int[] right = nextLargerRight(height);

        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));

        int len = height.length;

        int sol = 0;

        for (int i = 0; i < len; i++) {
            if (left[i] == -1 || right[i] == len) {
                continue;
            }
            int temp = Math.min(height[left[i]], height[right[i]]) - height[i];

            // System.out.println(i + " : " + temp);

            sol = sol + temp;
        }

        return sol;
    }

    // [0,2,0,3,1,0,1,3,2,1]

    int[] nextLargerRight(int[] array) {
        int len = array.length;
        int[] sol = new int[len];

        Stack<Integer> st = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {
            while (!st.isEmpty() && array[st.peek()] <= array[i]) {
                st.pop();
            }

            if (st.empty()) {
                sol[i] = len;
                st.push(i);
            } else {
                sol[i] = st.peek();
            }

            // st.push(i);
        }

        return sol;
    }

    int[] nextLargerLeft(int[] array) {
        int len = array.length;
        int[] sol = new int[len];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!st.isEmpty() && array[st.peek()] <= array[i]) {
                st.pop();
            }

            if (st.empty()) {
                sol[i] = -1;
                st.push(i);
            } else {
                sol[i] = st.peek();
            }

            // st.push(i);
        }

        return sol;
    }
}
