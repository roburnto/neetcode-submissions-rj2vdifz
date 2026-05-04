class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> index;
        for(int i = 0; i < nums.size(); i++){
            int comp = target - nums[i];
            if(index.contains(comp)){
                return {index[comp], i};
            }
            index[nums[i]]=i;
        }
    }
};
