package aToZStriverSheetJava._13_DP;

public class _SM_Wildcard_matching {

//    --- REcursion

    Boolean[][] dp;

    public boolean solve(int i, String s, int j, String p) {
        // Base Cases
        if (i < 0 && j < 0) {
            return true; // Both strings are fully processed
        }
        if (j < 0) {
            return false; // Pattern exhausted but string is not
        }
        if (i < 0) {
            // Check if the remaining pattern contains only '*'
            for (int ind = 0; ind <= j; ind++) {
                if (p.charAt(ind) != '*') {
                    return false;
                }
            }
            return true;
        }

        // Memoization Check
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // Matching Cases
        if (p.charAt(j) == '*') {
            // '*' can match zero or more characters
            return dp[i][j] = solve(i, s, j - 1, p) || solve(i - 1, s, j, p);
        }
        if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) {
            // '?' matches any single character or exact character match
            return dp[i][j] = solve(i - 1, s, j - 1, p);
        }

        // No match
        return dp[i][j] = false;
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        dp = new Boolean[m][n]; // Using Boolean for memoization (null checks)

        return solve(m - 1, s, n - 1, p);
    }

//    ------ DP

    class Solution {
        public boolean isMatch(String str, String pattern) {
            int strLen = str.length();
            int patLen = pattern.length();

            boolean[][] dp = new boolean[strLen + 1][patLen + 1];

            // Base cases
            dp[0][0] = true; // Empty string matches empty pattern

            // Fill first row for cases where pattern contains only '*'
            for (int j = 1; j <= patLen; j++) {
                if (pattern.charAt(j - 1) == '*') {
                    dp[0][j] = dp[0][j - 1];
                }
            }

            // Fill the DP table
            for (int i = 1; i <= strLen; i++) {
                for (int j = 1; j <= patLen; j++) {
                    if (pattern.charAt(j - 1) == str.charAt(i - 1) || pattern.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1]; // Characters match or '?'
                    } else if (pattern.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; // '*' matches zero or more characters
                    }
                }
            }

            return dp[strLen][patLen];
        }
    }


}
