class Solution:
    def maxArea(self, heights: List[int]) -> int:
        L,R = 0 , len(heights)-1
        area = 0
        while L<R:
            curr_area = min(heights[L], heights[R]) *(R-L)
            if( area <= curr_area):
                area = curr_area
            if(heights[L] < heights[R]):
                L+=1
            elif(heights[L] >= heights[R]):
                R -=1
            
        return area