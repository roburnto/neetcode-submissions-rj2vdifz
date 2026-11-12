class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return backtrack(s, t, 0, 0, dp);
    }

    private int backtrack(String s, String t, int curS, int curT, int[][] dp) {
        if (dp[curS][curT] != -1) {
            return dp[curS][curT];
        }
        if (curT == t.length()) {
            return 1;
        }
        int count = 0;
        for (int i = curS; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(curT)) {
                continue;
            }
            count += backtrack(s, t, i + 1, curT + 1, dp);
        }
        dp[curS][curT] = count;
        return count;
    }
}