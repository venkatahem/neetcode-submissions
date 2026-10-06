class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] sol = new int[n];

        n--;
        stack.push(n);
        sol[n] = 0;

        while (n >= 0 && !stack.isEmpty()) {
            int temp = temperatures[n];
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temp) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                sol[n] = 0;
            } else {
                sol[n] = stack.peek() - n;
            }
            stack.push(n);
            n--;
        }

        return sol;
    }
}
