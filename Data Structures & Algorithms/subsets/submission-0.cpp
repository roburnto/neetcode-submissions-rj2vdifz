class Solution {
   public:
    vector<vector<int>> res;
    vector<vector<int>> subsets(vector<int>& nums) {
        backtrack(nums, 0, {});
        return res;
    }
    void backtrack(vector<int>& nums, int i, vector<int> subset) {
        if (i >= nums.size()) {
            res.push_back(subset);
            return;
        }
        subset.push_back(nums[i]);
        backtrack(nums, i + 1, subset);
        subset.pop_back();
        backtrack(nums, i + 1, subset);
    }
};
