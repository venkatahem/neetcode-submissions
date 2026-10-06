class Solution {
    public int maxArea(int[] heights) {
        int sol = 0;

        int front = 0;
        int back = heights.length - 1;

        while (front < back) {
            int width = back - front;
            int height = Math.min(heights[front], heights[back]);

            int area = width * height;

            sol = Math.max(sol, area);

            if (heights[front] < heights[back]) {
                front++;
            } else if (heights[front] > heights[back]) {
                back--;
            } else if (heights[front] < heights[front + 1]) {
                front++;
            } else if (heights[back] < heights[back - 1]) {
                back--;
            } else {
                front++;
                back--;
            }
        }

        return sol;
    }
}
