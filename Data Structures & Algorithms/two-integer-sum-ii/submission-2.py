class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        
        res = []
        l,r = 0, len(numbers)-1
        
        while l < r:
            complement = target - numbers[l]
            if complement > numbers[r]:
                l +=1
            elif complement < numbers[r]:
                r -= 1
            else:
                return [l+1,r+1]
