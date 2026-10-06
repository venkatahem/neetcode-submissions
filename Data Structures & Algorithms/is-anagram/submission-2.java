class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        Map<Character,Integer> freqMap1 = new HashMap<>();
        Map<Character,Integer> freqMap2 = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            freqMap1.merge(a, 1, Integer::sum);
            freqMap2.merge(b, 1, Integer::sum);
        }

        for (Character key : freqMap1.keySet()) {
            System.out.println(key);
            System.out.println(freqMap1.get(key));
            System.out.println(freqMap2.get(key));
            if(!freqMap1.get(key).equals(freqMap2.get(key))){
                return false;
            }
        }

        return true;
    }
}
