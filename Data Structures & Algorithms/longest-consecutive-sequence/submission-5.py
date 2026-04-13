class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        res = 0
        num = set()
        for n in nums:
            num.add(n)

        for n in nums:
            length = 1
            x = n
            while (x-1) in num:
                length +=1
                x -= 1
            res = max(res, length)
        
        return res
        


