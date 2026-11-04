class Solution {
    public int splitArray(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }

        while (max < sum) {
            int mid = max + (sum - max) / 2;
            if (canSplit(nums, k, mid)) {
                sum = mid;
            } else {
                max = mid + 1;
            }
        }
        return max;
    }

    private boolean canSplit(int[] nums, int k, int limit) {
        int splits = 1;
        int runningSum = 0;
        for (int num : nums) {
            if (runningSum + num > limit) {
                splits++;
                if (splits > k) {
                    return false;
                }
                runningSum = num;
            } else {
                runningSum += num;
            }
        }
        return splits <= k;
    }
}