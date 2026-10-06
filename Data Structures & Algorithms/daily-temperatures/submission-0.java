class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();

        int[] sol = new int[temperatures.length];

        for(int i=temperatures.length-1; i >= 0; i--){
            if(st.isEmpty()){
                sol[i] = 0;
                st.push(i);
            }else if(st.isEmpty() && temperatures[st.peek()] > temperatures[i]){
                sol[i] = st.peek() - i;
                st.push(i);
            }else{
                while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    sol[i] = st.peek() - i;
                }else{
                    sol[i] = 0;
                }
                st.push(i);
            }
        }

        return sol;
    }
}
