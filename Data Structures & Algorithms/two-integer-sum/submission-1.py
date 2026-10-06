class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        numsMap = {}

        for i in range(0,len(nums)):
            diff = target - nums[i]
            if numsMap.get(diff) is None:
                numsMap[nums[i]] = i
            else:
                sol = [numsMap.get(diff),i]
                break

        return sol