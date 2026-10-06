class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        freqMap1 = {}
        freqMap2 = {}

        if(len(s) != len(t)):
            return False

        for i in range(0,len(s)):
            t1 = s[i]
            t2 = t[i]

            if freqMap1.get(t1) is None:
                freqMap1[t1] = 1
            else:
                freqMap1[t1] = freqMap1[t1] + 1

            if freqMap2.get(t2) is None:
                freqMap2[t2] = 1
            else:
                freqMap2[t2] = freqMap2[t2] + 1

        for alph,occu in freqMap1.items():
            if occu != freqMap2.get(alph):
                return False 

        return True
        