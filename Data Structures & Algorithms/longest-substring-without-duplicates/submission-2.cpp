class Solution {
   public:
    int lengthOfLongestSubstring(string s) {
        if (s.length() == 0) {
            return 0;
        }
        unordered_set<char> charSet;
        int maxLength = 0;
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            while (charSet.contains(s[r])) {
                charSet.erase(s[l]);
                l++;
            }
            charSet.insert(s[r]);
            maxLength = max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;
    }
};
