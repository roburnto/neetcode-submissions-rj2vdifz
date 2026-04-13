class Solution:
    def maxArea(self, heights: List[int]) -> int:
        l, r = 0, len(heights)-1
        max_area = 0

        while l < r:
            leftHeight = heights[l]
            rightHeight = heights[r]
            area = min(leftHeight, rightHeight) * (r-l)
            if leftHeight > rightHeight:
                r-=1
            else:
                l +=1
            max_area = max(area,max_area)
        
        return max_area