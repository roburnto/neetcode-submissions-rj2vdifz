class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = []
        l, r = 0, k

        while r < len(nums):
            res.append(max(nums[l:r]))
            l+=1
            r+=1
        
        res.append(max(nums[l:r]))
        return res