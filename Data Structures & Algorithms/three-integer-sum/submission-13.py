class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        # sorting to be able to use pointers
        nums.sort()
        # enumerate for easy access to values
        for i,a in enumerate(nums):
            # if a is ever above 0 no sums can be equal to 0 
            if a > 0:
                break
            # if it is duplicate continue so there's no duplicates
            if i > 0 and  a == nums[i-1]:
                continue
            
            # two pointers
            l, r = i + 1, len(nums)-1
            while l < r:
                threeSum = a + nums[l] + nums[r]
                if threeSum>0:
                    r -= 1
                elif threeSum < 0:
                    l += 1
                else:
                    res.append([a, nums[l], nums[r]])
                    l+=1
                    r-=1
                    # skip duplicates
                    while nums[l]== nums[l-1] and l < r:
                        l+=1
        
        return res