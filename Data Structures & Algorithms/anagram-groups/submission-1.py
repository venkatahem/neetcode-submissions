class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagramMap = {}

        for string in strs:
            freqMap = {}
            for char in string:
                if freqMap.get(char) is None:
                    freqMap[char] = 1
                else:
                    freqMap[char] = freqMap.get(char) + 1

            # print(freqMap)

            tup = tuple(sorted(freqMap.items()))
            # print(tup)

            if anagramMap.get(tup) is None:
                anagramMap[tup] = [string]
            else:
                anagramMap.get(tup).append(string)

        sol = []

        for val in anagramMap.values():
            sol.append(val)

        return sol
        