class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = nearestSmallestToLeft(heights);
        int[] right = nearestSmallestToRight(heights);

        int sol = 0;

        for(int i=0; i<heights.length; i++){
            int temp = ((right[i] - 1) - (left[i] + 1) + 1) * heights[i];
            sol = Math.max(sol,temp);
        }

        return sol;
    }

    // [7,1,7,2,2,4]

    int[] nearestSmallestToLeft(int[] array){
        Stack<Integer> st = new Stack<>();

        int len = array.length;
        int[] sol = new int[len];

        for(int i=0; i<len; i++){
            while(!st.isEmpty() && array[i] <= array[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                sol[i] = -1;
            }else{
                sol[i] = st.peek();
            }
            st.push(i);
        }

        return sol;
    }

    int[] nearestSmallestToRight(int[] array){
        Stack<Integer> st = new Stack<>();

        int len = array.length;
        int[] sol = new int[len];

        for(int i=len-1; i>=0; i--){
            while(!st.isEmpty() && array[i] <= array[st.peek()]){
                st.pop();
            }

            if(st.isEmpty()){
                sol[i] = len;
            }else{
                sol[i] = st.peek();
            }
            st.push(i);
        }

        return sol;
    }
}
