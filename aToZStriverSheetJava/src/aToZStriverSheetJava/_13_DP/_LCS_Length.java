package aToZStriverSheetJava._13_DP;

//link - https://leetcode.com/problems/longest-common-subsequence/

import java.util.Arrays;

public class _LCS_Length {
//    ----- recursion
    int[][] dp ;
    public int solve(int i, int j, String text1, String text2){
        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] = 1 + solve(i-1, j-1, text1, text2);
        }
        return dp[i][j] = Math.max(solve(i-1, j, text1, text2),
                solve(i, j-1, text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        dp = new int[n1+1][n2+1];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }

        return solve(n1-1, n2-1, text1, text2);
    }

//    -------- DP

    public int longestCommonSubsequence_dp(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1+1][n2+1];
        for(int[] d: dp){
            Arrays.fill(d, 0);
        }

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n1][n2];
    }
}
