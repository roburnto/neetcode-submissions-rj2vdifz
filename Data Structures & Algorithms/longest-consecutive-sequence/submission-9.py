class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num = set(nums)
        consecutive = 0
        for n in num:
            i = 1
            while n-i in num:
                i +=1
            
            consecutive = max(consecutive, i)

        return consecutive
