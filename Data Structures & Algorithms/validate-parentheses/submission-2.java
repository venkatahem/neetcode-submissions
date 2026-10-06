class Solution {
    public boolean isValid(String s) {
        Set<Character> open = Set.of('(', '{', '[');
        Set<Character> close = Set.of(')', '}', ']');

        Map<Character, Character> map = new HashMap<>();

        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (open.contains(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char ch1 = stack.pop();
                if (map.get(ch) == ch1) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
