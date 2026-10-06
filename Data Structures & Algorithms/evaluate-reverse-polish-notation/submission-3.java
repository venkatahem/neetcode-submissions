class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>(Set.of("+", "-", "*", "/"));

        int a;
        int b;
        String operator;

        Stack<String> st = new Stack<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            String temp = tokens[i];
            if (operators.contains(temp)) {
                st.push(temp);
            } else if (st.isEmpty() || operators.contains(st.peek())) {
                st.push(temp);
            } else {
                int result = Integer.parseInt(temp);
                while (!st.isEmpty() && !operators.contains(st.peek())) {
                    a = result;
                    b = Integer.parseInt(st.pop());

                    operator = st.pop();

                    result = calculate(a, b, operator);
                }
                st.push(String.valueOf(result));
            }
            // System.out.println(st);
        }

        // while (st.size() > 1) {
        //     a = Integer.parseInt(st.pop());
        //     b = Integer.parseInt(st.pop());

        //     operator = st.pop();
        //     int result = calculate(a, b, operator);

        //     st.push(String.valueOf(result));
        // }

        return Integer.parseInt(st.pop());
    }

    public int calculate(int a, int b, String operator) {
        int val = 0;
        switch (operator) {
            case "+":
                val = a + b;
                break;
            case "-":
                val = a - b;
                break;
            case "*":
                val = a * b;
                break;
            case "/":
                val = a / b;
        }

        return val;
    }
}
