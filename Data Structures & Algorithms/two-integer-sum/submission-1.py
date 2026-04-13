class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #twosum map
        index = {}


        for i, num in enumerate(nums):

            complement = target-num
            if complement in index:
                return [index[complement], i]
            index[num] = i
            

