class Solution {
   public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> index;
        for (string str : strs) {
            vector<int> charCount(26, 0);
            for (char c : str) {
                charCount[c - 'a'] += 1;
            }
            string key = to_string(charCount[0]);
            for (int i = 1; i < 26; i++) {
                key += ',' + to_string(charCount[i]);
            }
            index[key].push_back(str);
        }
        vector<vector<string>> res;
        for (auto& pair : index) {
            res.push_back(pair.second);
        }
        return res;
    }
};
