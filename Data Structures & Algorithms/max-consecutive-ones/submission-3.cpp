class Solution {
   public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int maxSequence = 0;
        int l = 0, r = 0;
        while (r < nums.size()) {
            if (nums[r] == 1) {
                maxSequence = max(maxSequence, r - l + 1);
            } else {
                l = r + 1;
            }
            r++;
        }
        return maxSequence;
    }
};