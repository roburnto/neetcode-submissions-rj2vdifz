class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            while (!Character.isLetterOrDigit(cl) && l < r) {
                l++;
                cl = s.charAt(l);
            }
            while (!Character.isLetterOrDigit(cr) && l < r) {
                r--;
                cr = s.charAt(r);
            }
            if (Character.toLowerCase(cl) != Character.toLowerCase(cr)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
