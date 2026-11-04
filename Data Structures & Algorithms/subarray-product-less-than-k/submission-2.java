class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        if (k <= 1) {
            return count;
        }
        int l = 0;
        int product = 1;
        for (int r = 0; r < n; r++) {
            product *= nums[r];
            while (product >= k && l <= r) {
                product /= nums[l];
                l++;
            }
            count += (r - l + 1);
        }
        return count;
    }
}