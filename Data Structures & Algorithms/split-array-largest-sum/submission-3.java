class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = nums[0];

        for (int num : nums) {
            sum += num;
            max = Math.max(num, max);
        }

        int l = max;
        int r = sum;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (canSplit(nums, k, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private boolean canSplit(int[] nums, int k, int value) {
        int curSplits = 1;
        int curSum = 0;
        for (int num : nums) {
            if (num + curSum > value) {
                curSum = 0;
                curSplits++;
            }
            if (curSplits > k) {
                return false;
            }
            curSum += num;
        }

        return true;
    }
}