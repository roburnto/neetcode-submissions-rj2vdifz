class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        num_set = set(nums)
        longest_streak = 0
        
        for num in num_set:
            if(num - 1) not in num_set:
                length = 1
                while(num+length) in num_set:
                    length +=1
                
                longest_streak = max(length, longest_streak)
        
        return longest_streak
            
