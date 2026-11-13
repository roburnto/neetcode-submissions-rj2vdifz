
class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = nums[0];

        // Find the total sum and largest element.
        // Minimum possible answer = max element (can't split an element).
        // Maximum possible answer = total sum (one subarray).
        for (int num : nums) {
            sum += num;
            max = Math.max(num, max);
        }

        if (k == nums.length) {
            return max;
        }

        if (k == 1) {
            return sum;
        }

        // Binary search for the smallest possible maximum subarray sum.
        int l = max;
        int r = sum;

        while (l < r) {
            int m = l + (r - l) / 2;

            // Check if we can split the array into at most k
            // subarrays, each having a sum <= m.
            if (canSplit(nums, k, m)) {
                // m is valid, so try finding a smaller maximum sum.
                r = m;
            } else {
                // m is too small, so increase the allowed sum.
                l = m + 1;
            }
        }

        // l == r: smallest maximum subarray sum that works.
        return l;
    }

    private boolean canSplit(int[] nums, int k, int value) {
        // Start with one subarray.
        int curSplits = 1;
        int curSum = 0;

        for (int num : nums) {
            // If adding this number exceeds the allowed sum,
            // start a new subarray.
            if (num + curSum > value) {
                curSum = num;
                curSplits++;
                if (curSplits > k) {
                    return false;
                }
            } else {
                curSum += num;
            }
        }

        // Successfully split into at most k subarrays.
        return true;
    }
}
