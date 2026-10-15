class Solution {
    public int trap(int[] height) {
        // Time: O(n) - each pointer moves across the array at most once
        // Space: O(1) - only a constant number of variables are used

        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0, r = height.length - 1; // Two pointers starting at both ends

        int leftMax = height[l], rightMax = height[r]; // Track max heights seen from each side
        int res = 0; // Total trapped water

        while (l < r) {
            // Process the side with the smaller max since it determines the water level
            if (leftMax < rightMax) {
                l++; // Move the left pointer inward
                leftMax = Math.max(leftMax, height[l]); // Update the maximum height from the left
                res += leftMax - height[l]; // Add water trapped at the current position
            } else {
                r--; // Move the right pointer inward
                rightMax =
                    Math.max(rightMax, height[r]); // Update the maximum height from the right
                res += rightMax - height[r]; // Add water trapped at the current position
            }
        }

        return res;
    }
}