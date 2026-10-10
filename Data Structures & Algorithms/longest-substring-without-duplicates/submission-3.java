class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int maxL = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++){
            while(l < r && seen.contains(s.charAt(r))){
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            maxL = Math.max(maxL, r-l+1);
        }
        return maxL;
    }
}
