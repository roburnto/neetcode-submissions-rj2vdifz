class Solution {
   public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> freq;
        for (int num : nums) {
            freq[num] = 1 + freq[num];
        }
        vector<vector<int>> buckets(nums.size()+1);
        
        for(auto& pair : freq){
            buckets[pair.second].push_back(pair.first);
        }
        vector<int> res;
        for(int i = buckets.size()-1; i >= 0 ; i--){
            for(int n : buckets[i]){
                res.push_back(n);
            }
            if (res.size() >= k){
                return res;
            }
        }
        return res;
    }
};
