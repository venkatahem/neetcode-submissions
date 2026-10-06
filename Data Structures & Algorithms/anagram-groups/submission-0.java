class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Character,Integer> freqMap;
        Map<Map<Character,Integer>,List<String>> anagramMap = new HashMap<>();

        for(String str: strs){
            freqMap = new HashMap<>();
            for(Character c: str.toCharArray()){
                freqMap.merge(c, 1, Integer::sum);
            }
            if(anagramMap.containsKey(freqMap)){
                anagramMap.get(freqMap).add(str);
            }else{
                List<String> strList = new ArrayList<>();
                strList.add(str);
                anagramMap.put(freqMap,strList);
            }
        }

        List<List<String>> sol = new ArrayList<>();
        for(List<String> values: anagramMap.values()){
            sol.add(values);
        }

        return sol;
    }
}
