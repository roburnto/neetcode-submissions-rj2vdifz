class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        #initialize the pointers
        l,r = 0, len(numbers)-1

        while l < r:
            complement = target-numbers[l]
            if numbers[r] > complement:
                r -= 1
            elif numbers[r] < complement:
                l +=1
            else:
                return [l+1,r+1]
        