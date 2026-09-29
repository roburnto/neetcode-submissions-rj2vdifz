class Solution {
   public:
    int singleNonDuplicate(vector<int>& nums) {
        int l = 0;
        int r = nums.size() - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] != nums[m - 1] && nums[m] != nums[m + 1]) {
                return nums[m];
            }
            if (m % 2 == 0) {
                if (nums[m] == nums[m + 1]) {
                    // do something
                    l = m + 1;
                } else {
                    // do something
                    r = m - 1;
                }
            } else {
                if (nums[m] == nums[m + 1]) {
                    // do something
                    r = m - 1;
                } else {
                    // do something
                    l = m + 1;
                }
            }
        }
        return nums[(l + r) / 2];
    }
};