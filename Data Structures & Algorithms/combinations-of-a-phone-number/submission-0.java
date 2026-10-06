class Solution {
    Map<Character, String> digitToChars;
    List<String> sol;
    public List<String> letterCombinations(String digits) {
        digitToChars = new HashMap<>();
        sol = new ArrayList<>();

        digitToChars.put('2', new String("abc"));
        digitToChars.put('3', new String("def"));
        digitToChars.put('4', new String("ghi"));
        digitToChars.put('5', new String("jkl"));
        digitToChars.put('6', new String("mno"));
        digitToChars.put('7', new String("pqrs"));
        digitToChars.put('8', new String("tuv"));
        digitToChars.put('9', new String("wxyz"));

        solve(digits, 0, new StringBuilder());

        return sol;
    }
    // pass the digit and associated map and call the fuction recursively for next digit and
    // associated map of that digit , if it is the last digit then generate all solutions for that
    // digit and return
    private void solve(String digits, int index, StringBuilder tempSol) {
        if (digits.isEmpty()) {
            return;
        }
        if (index == digits.length() - 1) {
            String chars = digitToChars.get(digits.charAt(index));
            for (Character ch : chars.toCharArray()) {
                tempSol.append(ch);
                sol.add(new String(tempSol));
                tempSol.deleteCharAt(index);
            }
            return;
        }

        char currentChar = digits.charAt(index);
        String currentChars = digitToChars.get(currentChar);

        for (Character ch1 : currentChars.toCharArray()) {
            tempSol.append(ch1);
            solve(digits, index + 1, tempSol);
            tempSol.deleteCharAt(index);
        }
    }
}
