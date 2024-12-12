package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

public class _2D_Min_Path_Sum {

//    ------- RECURSIVE
    int[][] dp ;
    public int solve(int m, int n, int[][] grid){
        if(m == 0 && n == 0){
            return grid[m][n];
        }
        if(m < 0 || n < 0){
            return Integer.MAX_VALUE;
        }
        if(dp[m][n] != Integer.MAX_VALUE){
            return dp[m][n];
        }
        int up = solve(m-1, n, grid);
        int left = solve(m, n-1, grid);

        return dp[m][n] = grid[m][n] + Math.min(up, left);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for(int[] a: dp){
            Arrays.fill(a, Integer.MAX_VALUE);
        }

        return solve(m-1, n-1, grid);
    }



//    ------ DP
    public int minPathSum_dp(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }
                else if(i == 0){
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }
                else if(j == 0){
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }
                else{
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m-1][n-1];
    }
}
