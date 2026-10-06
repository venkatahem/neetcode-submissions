class Solution {

    // "Hello" -> 5,"World" -> 5
    // 5Hello5World
    // 201 

    public String encode(List<String> strs) {
        StringBuilder sb1 = new StringBuilder();

        for(String str: strs){
            String div = buildDiv(str.length());
            sb1.append(div+str);
        }

        // System.out.println(sb1.toString());

        return sb1.toString();

    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();

        for(int i=0; i < str.length(); ){
            String div = str.substring(i,i+3);
            int length = getLengthFromDiv(div);
            i = i+3;
            String temp = str.substring(i,i+length);
            strs.add(temp);
            i = i+length;
        }
        return strs;
    }

    public String buildDiv(int length){
        return Integer.toString(201+length);
    }

    public int getLengthFromDiv(String div){
        int len = Integer.parseInt(div) - 201;
        return len;
    }
}
