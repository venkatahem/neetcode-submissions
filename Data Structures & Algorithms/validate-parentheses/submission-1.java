class Solution {
    public boolean isValid(String s) {
        Set<Character> open = new HashSet<>(Set.of('(', '{', '['));
        Set<Character> close = new HashSet<>(Set.of(')', '}', ']'));

        Map<Character, Character> pair = new HashMap<>();
        pair.put('(', ')');
        pair.put('{', '}');
        pair.put('[', ']');

        Stack<Character> st = new Stack<>();

        for (Character ch : s.toCharArray()) {
            if (open.contains(ch)) {
                st.push(ch);
            }
            if (close.contains(ch)) {
                if (!st.isEmpty()) {
                    if (!pair.get(st.pop()).equals(ch)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}
