class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        triplets = []

        for i, val in enumerate(nums):
            # continue if number is duplicate
            if (i > 0) & (val == nums[i - 1]):
                continue

            if nums[i] > 0:
                break

            left = i + 1
            right = len(nums) - 1

            while left < right:
                currSum = val + nums[left] + nums[right]
                if currSum > 0:
                    right -= 1
                elif currSum < 0:
                    left += 1
                else:
                    triplets.append([val, nums[left], nums[right]])
                    left += 1
                    right -= 1
                    while (left < right) & (nums[left] == nums[left - 1]):
                        left += 1
                    while (left < right) & (nums[right] == nums[right + 1]):
                        right -= 1

        return triplets
