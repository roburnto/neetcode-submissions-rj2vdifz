
class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = nums[0];

        // Find the total sum and largest element to establish search bounds.
        for (int num : nums) {
            sum += num;
            max = Math.max(num, max);
        }

        // Each element forms its own subarray, so return the largest element.
        if (k == nums.length) {
            return max;
        }

        // Only one subarray is allowed, so return the total sum.
        if (k == 1) {
            return sum;
        }

        // Lower Bound Binary Search on Answer: find the smallest valid maximum sum.
        int l = max;
        int r = sum;

        while (l < r) {
            int m = l + (r - l) / 2;

            // If m is feasible, search for a smaller valid maximum sum.
            if (canSplit(nums, k, m)) {
                r = m;
            } else {
                // If m is infeasible, increase the maximum allowed sum.
                l = m + 1;
            }
        }

        // Return the smallest feasible maximum subarray sum.
        return l;
    }

    // Greedily check if nums can be split into at most k subarrays with sums <= value.
    private boolean canSplit(int[] nums, int k, int value) {
        int curSplits = 1;
        int curSum = 0;

        for (int num : nums) {
            // Start a new subarray if adding num exceeds the allowed sum.
            if (curSum + num > value) {
                curSum = num;
                curSplits++;

                // Return false if more than k subarrays are required.
                if (curSplits > k) {
                    return false;
                }
            } else {
                // Otherwise, add num to the current subarray.
                curSum += num;
            }
        }

        // Return true if at most k subarrays were needed.
        return true;
    }
}
