package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

public class _SM_Edit_Distance {
//    ----- recursion
    int[][] dp;
    public int solve(int i, int j, String s, String t){
        if(i < 0){
            return j+1; // num of operations required to match
        }
        if(j < 0){
            return i+1; // num of operations required to match
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = 0 + solve(i-1, j-1, s, t);
        }else{
            return dp[i][j] = 1 + Math.min(solve(i-1, j-1, s, t), // replace
                    Math.min(solve(i-1, j, s, t), // delete
                            solve(i, j-1, s, t))); // insert
        }
    }


    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        dp = new int[m][n];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }

        return solve(m-1, n-1, word1, word2);
    }


//    ------- DP

    public int minDistance_dp(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=n; j++){
            dp[0][j] = j;
        }

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 +  Math.min(dp[i-1][j-1],
                            Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }

        return dp[m][n];
    }
}
