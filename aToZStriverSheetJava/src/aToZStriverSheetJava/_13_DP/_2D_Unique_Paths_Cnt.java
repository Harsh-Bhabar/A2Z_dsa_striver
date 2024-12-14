package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

//link - https://leetcode.com/problems/unique-paths/description/

public class _2D_Unique_Paths_Cnt {

//    -------- RECURSIVE
    int[][] dp ;

    public int solve(int m, int n){
        if(m == 0 && n == 0){
            return 1;
        }
        if(m < 0 || n < 0){
            return 0;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }

        int left = solve(m, n-1);
        int up = solve(m-1, n);

        return dp[m][n] = left + up;
    }

    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }

        return solve(m-1, n-1);
    }

//    --------- DP
    public int uniquePaths_2(int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(i == 1 || j == 1){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m][n];
    }

}
