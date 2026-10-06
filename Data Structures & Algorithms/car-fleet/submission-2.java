class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[] jumps = new int[position.length];
        Stack<Double> st = new Stack<>();

        int n = position.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (i1, i2) -> Integer.compare(position[i2], position[i1]));

        int[] sortedKeys = new int[n];
        int[] sortedValues = new int[n];

        for (int i = 0; i < n; i++) {
            sortedKeys[i] = position[indices[i]];
            sortedValues[i] = speed[indices[i]];
        }

        System.arraycopy(sortedKeys, 0, position, 0, n);
        System.arraycopy(sortedValues, 0, speed, 0, n);

        for (int i = 0; i < position.length; i++) {
            double temp = (double) (target - position[i]) / speed[i];
            if(!st.empty()){
                if(temp > st.peek()){
                    st.push(temp);
                }
            }else{
                st.push(temp);
            }
        }

        return st.size();
    }
}
