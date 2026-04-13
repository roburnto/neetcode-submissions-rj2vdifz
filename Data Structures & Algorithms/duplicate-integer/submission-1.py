class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        #set to keep track of values
        dup = set()
        for num in nums:
            if num in dup:
                return True
            else:
                dup.add(num)

        return False