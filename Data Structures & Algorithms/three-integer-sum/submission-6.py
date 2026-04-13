class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        #sort the array
        nums.sort()
        res = []
        for i, num in enumerate(nums):
            if i > 0 and num == nums[i-1]:
                continue
            if num > 0:
                break
            l,r = i+1, len(nums)-1
            target = 0-num
            while l < r:
                complement = target - nums[l]
                if nums[r] > complement:
                    r-=1
                elif nums[r]< complement:
                    l+=1
                else:
                    res.append([num,nums[l],nums[r]])
                    #skip dupe values for l
                    while l < r and nums[l] == nums[l+1]:
                        l+=1
                    #skip dupe values for r
                    while l < r and nums[r] == nums[r-1]:
                        r-=1

                    l+=1
                    r-=1


        return res

        
        