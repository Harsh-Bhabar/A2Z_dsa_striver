package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

//link - https://leetcode.com/problems/minimum-falling-path-sum/

public class _2D_Min_FALLING_Path_Sum {
//    ------- recursion

    int[][] dp ;

    public int solve(int i, int j, int[][] matrix){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix.length){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }
        if(i==0){
            return matrix[i][j];
        }

        int up = solve(i-1, j, matrix);
        int dLeft = solve(i-1, j-1, matrix);
        int dRight = solve(i-1, j+1, matrix);

        return dp[i][j] = matrix[i][j] + Math.min(up, Math.min(dLeft, dRight));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        if(n == 1){
            return Arrays.stream(matrix[0]).min().orElse(1);
        }

        dp = new int[n][n];
        for(int[] a: dp){
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        for(int j=0; j<n; j++){
            solve(n-1, j, matrix);
        }

        int ans = Integer.MAX_VALUE;
        for(int j=0; j<n; j++){
            ans = Math.min(ans, dp[n-1][j]);
        }

        return ans;
    }


//    ------- dp


    public int minFallingPathSum_dp(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for(int i=n-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(i == n-1){
                    dp[i][j] = matrix[i][j];
                }else{
                    int dLeft = (j > 0) ? dp[i+1][j-1] : Integer.MAX_VALUE;
                    int up = dp[i+1][j];
                    int dRight = (j < n-1) ? dp[i+1][j+1] : Integer.MAX_VALUE;

                    dp[i][j] = matrix[i][j] + Math.min(up, Math.min(dLeft, dRight));
                }
            }
        }

        return Arrays.stream(dp[0]).min().orElse(-1);
    }


}
