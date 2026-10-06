class Solution {
    public int maxArea(int[] heights) {
        int max = -1;

        int front = 0;
        int back = heights.length-1;

        while(front<back){
            int width = back - front;

            int area = width * Math.min(heights[front],heights[back]);

            max = Math.max(area,max);

            if(heights[front] < heights[back]){
                front++;
            }else if(heights[front] > heights[back]){
                back--;
            }else{
                front++;
                back--;
            }
        }

        return max;
    }
}
