class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        prefix = []
        suffix = []

        front = 0
        back = len(nums) - 1

        a = 1
        b = 1

        while front < len(nums) and back >= 0:
            prefix.append(a)
            suffix.insert(0,b)

            a = a * nums[front]
            b = b * nums[back]

            front += 1
            back -= 1

        sol = []

        for (a,b) in zip(prefix,suffix):
            sol.append(a*b)      

        return sol