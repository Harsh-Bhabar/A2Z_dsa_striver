package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

public class _SM_Distinct_Subsequences {

//    ------ Recursion
    int[][] dp;
    public int solve(int i, int j, String s, String t){
        if(j < 0){
            return 1; // all chars of t processed
        }
        if(i < 0) {
            return 0; // no match found
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = (solve(i-1, j-1, s, t) + solve(i-1, j, s, t));
        }else{
            return dp[i][j] = solve(i-1, j, s, t);
        }
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        dp = new int[m][n];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }

        return solve(m-1, n-1, s, t);
    }

//    ------ DP

    public int numDistinct_2(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m+1][n+1];

        for(int j=0; j<=n; j++){
            dp[0][j] = 0;
        }
        for(int i=0; i<=m; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[m][n];
    }
}
