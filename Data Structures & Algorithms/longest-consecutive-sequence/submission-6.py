class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        x = set(nums)
        longest = 0
        for num in x:
            if (num-1) not in x:
                length = 1
                while (num+length) in x:
                    length +=1
                longest = max(length, longest)
        return longest