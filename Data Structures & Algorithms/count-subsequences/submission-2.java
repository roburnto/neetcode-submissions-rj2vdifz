class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return backtrack(s, t, 0, 0, dp);
    }

    private int backtrack(String s, String t, int curS, int curT, int[][] dp) {
        if (curT == t.length()) {
            return 1;
        }
        if (curS >= s.length()) {
            return 0;
        }
        if (dp[curS][curT] != -1) {
            return dp[curS][curT];
        }
        int count = 0;

        if (s.charAt(curS) == t.charAt(curT)) {
            // Calculate take
            int take = backtrack(s, t, curS + 1, curT + 1, dp);
            // Calculate skip
            int skip = backtrack(s, t, curS + 1, curT, dp);
            // Combine their results
            count = take + skip;
        } else {
            // Only skip is possible
            int skip = backtrack(s, t, curS + 1, curT, dp);
            count = skip;
        }

        dp[curS][curT] = count;
        return count;
    }
}