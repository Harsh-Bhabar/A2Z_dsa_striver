package aToZStriverSheetJava._13_DP;

import java.util.*;

//link - https://leetcode.com/problems/triangle/description/

public class _2D_Min_Path_Sum_TRIANGLE {
//    ----- recursion

    int[][] dp;

    public int solve(int i, int j, List<List<Integer>> grid, int n){
        if(i == n-1){
            return grid.get(n-1).get(j);
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int below = solve(i+1, j, grid, n);
        int diag = solve(i+1, j+1, grid, n);

        return dp[i][j] = grid.get(i).get(j) + Math.min(below, diag);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }

        return solve(0, 0, triangle, n);
    }

//    ------ DP
    public int minimumTotal_2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        for(int j=n-1; j>=0; j--){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                int down = dp[i+1][j];
                int diag = dp[i+1][j+1];
                dp[i][j] = triangle.get(i).get(j) + Math.min(down, diag);
            }
        }

        return dp[0][0];
    }
}
