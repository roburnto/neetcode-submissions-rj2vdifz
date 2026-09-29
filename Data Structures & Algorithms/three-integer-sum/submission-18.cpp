class Solution {
   public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> trios;

        for (int i = 0; i < nums.size(); i++) {
            int curr = nums[i];
            int r = nums.size() - 1;
            int l = i + 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }

            while (r > l) {
                int currSum = curr + nums[r] + nums[l];

                if (currSum > 0) {
                    r--;
                } else if (currSum < 0) {
                    l++;
                } else {
                    trios.push_back({nums[i], nums[r], nums[l]});
                    l++;
                    r--;
                    while (nums[l] == nums[l - 1] && l < r) {
                        l++;
                    }
                    while (nums[r] == nums[r + 1] && r > l) {
                        r--;
                    }
                }
            }
        }
        return trios;
    }
};
