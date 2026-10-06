class Solution {
    public boolean isPalindrome(String s) {

        String noSpace = s.trim().replace(" ","").toLowerCase();

        int end = noSpace.length();
        end--;

        for(int front = 0; front<noSpace.length() && end>=0; ){
            if(!validAlphaNumeric(noSpace.charAt(end))){
                end--;
                continue;
            }

            if(!validAlphaNumeric(noSpace.charAt(front))){
                front++;
                continue;
            }

            if(noSpace.charAt(front) == noSpace.charAt(end)){
                end--;
                front++;
            }else{
                return false;
            }
        }

        return true;
    }

    private boolean validAlphaNumeric(char ch){
        if(Character.isLetterOrDigit(ch)){
            return true;
        }

        return false;
    }

}
