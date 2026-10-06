class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> freq = new HashMap<>();

        int maxFreq = 0;
        
        int front = 0;
        int back = 0;
        int maxLength = 0;

        while(back < s.length()){
            char ch = s.charAt(back);
            freq.merge(ch,1,Integer::sum);
            maxFreq = Math.max(freq.get(ch),maxFreq);
            if(back - front + 1 - maxFreq <= k){
                maxLength = Math.max(maxLength,back-front+1);
            }else{
                char f = s.charAt(front);
                freq.computeIfPresent(f, (key,val) -> val-1);
                front++;
            }
            back++;
        }

        return maxLength;
    }
}
