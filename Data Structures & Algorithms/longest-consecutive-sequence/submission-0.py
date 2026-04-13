class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        hash = set(nums)
        count = 0
        for num in nums:
            count2 = 1
            sequence = True
            while(sequence == True):
                if(num+count2) in hash:
                    count2 += 1
                else:
                    sequence = False
            if(count2 >= count):
                count = count2
        
        return count