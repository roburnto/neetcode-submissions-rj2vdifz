class Solution {
    public int maxSubArray(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
        int curSum = 0;
        while (r < nums.length) {
            curSum += nums[r];
            if (nums[r] > curSum) {
                curSum = nums[r];
                l = r;
            }
            r++;
            maxVal = Math.max(maxVal, curSum);
        }
        return maxVal;
    }
}
