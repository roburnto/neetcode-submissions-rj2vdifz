class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        int idx = -1;
        if (n > m) {
            return idx;
        }
        int i = 0;
        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(0) && (i + n <= m)) {
                if (matches(haystack.substring(i, i + n), needle)) {
                    return i;
                }
            }
            i++;
        }
        return idx;
    }

    public boolean matches(String s, String needle) {
        return s.equals(needle);
    }
}