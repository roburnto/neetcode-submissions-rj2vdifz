class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        max_seq = 0
        for i, num in enumerate(nums):
            count = 0
            if num-1 in num_set:
                continue
            while num+count in num_set:
                count+=1

            max_seq = max(max_seq, count)

        return max_seq
            