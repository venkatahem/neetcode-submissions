class Solution {
    public boolean checkInclusion(String s1, String s2) {

        Map<Character,Integer> fs1 = new HashMap<>();
        Map<Character,Integer> fs2 = new HashMap<>();

        boolean sol = false;

        if(s1.length()>s2.length()){
            return false;
        }

        for(Character ch: s1.toCharArray()){
            fs1.merge(ch,1,Integer::sum);
        }

        int back = 0;
        int front = 0;
        
        while(back < s2.length()){
            fs2.merge(s2.charAt(back),1,Integer::sum);
            if(back - front + 1 == s1.length()){
                if(fs2.equals(fs1)){
                   sol = true;
                   break;
                }else{
                    char ch1 = s2.charAt(front);
                    fs2.computeIfPresent(ch1,(key,val) -> val-1);
                    if (fs2.get(ch1) == 0) {
                        fs2.remove(ch1);
                    }
                    front++;
                }
            }
            
            back++;
        }

        return sol;
    }
}
