class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> sol = new ArrayList<>();

        Map<String,List<String>> map = new HashMap<>();

        for(String str: strs){
            int[] freq = new int[26];
            for(char ch: str.toCharArray()){
                freq[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for(int i=0;i<26;i++){
                if(freq[i]>0){
                    sb.append(i+":"+freq[i]);
                }
            }

            if(map.containsKey(sb.toString())){
                map.get(sb.toString()).add(str);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(sb.toString(),temp);
            }
        }

        for(List<String> list: map.values()){
            sol.add(list);
        }

        return sol;
    }
}
