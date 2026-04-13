class Solution:
    def maxArea(self, heights: List[int]) -> int:
        m_area = 0
        l,r = 0, len(heights)-1

        while l < r:
            min_h = min(heights[l], heights[r])
            area = (min_h)*(r-l)
            m_area = max(area,m_area)
            if heights[l] < heights[r]:
                l+=1
            else:
                r -= 1

        return m_area
        