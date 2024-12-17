package aToZStriverSheetJava._13_DP;

//https://leetcode.com/problems/longest-palindromic-subsequence/

public class _LP_SS_Length {
    public int longestPalindromeSubseq(String s) {
        int n1 = s.length();
        String t = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[n1+1][n1+1];

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n1; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n1][n1];
    }
}
