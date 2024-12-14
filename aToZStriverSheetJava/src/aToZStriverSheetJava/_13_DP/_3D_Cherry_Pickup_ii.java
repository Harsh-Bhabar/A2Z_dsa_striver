package aToZStriverSheetJava._13_DP;

import java.util.Arrays;
//link - https://leetcode.com/problems/cherry-pickup-ii/

public class _3D_Cherry_Pickup_ii {

//    ------- recursion
    int[][][] dp ;

    public int solve(int i, int j1, int j2, int[][] grid, int r, int c){
        if(i >= grid.length || j1 < 0 || j2 < 0 || j1 >= c || j2 >= c){
            return Integer.MIN_VALUE;
        }

        if(i == r-1){
            if(j1 == j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1] + grid[i][j2];
            }
        }

        if(dp[i][j1][j2] != Integer.MIN_VALUE){
            return dp[i][j1][j2];
        }

        // explore all paths simultaneoulsy
        int maxi = Integer.MIN_VALUE;
        for(int dj1=-1; dj1 <= 1; dj1++){
            for(int dj2 =-1; dj2 <= 1; dj2++){
                int val = 0;
                if(j1 == j2){
                    val = grid[i][j1];
                }else{
                    val = grid[i][j1] + grid[i][j2];
                }
                val += solve(i+1, j1+dj1, j2+dj2, grid, r, c);
                maxi = Math.max(maxi, val);
            }
        }

        return maxi;
    }

    public int cherryPickup(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n][n];
        for(int[][] dd: dp){
            for(int[] d: dd){
                Arrays.fill(d, Integer.MIN_VALUE);
            }
        }

        return solve(0, 0, n-1, grid, m, n);
    }

//    -------- dp


    public int cherryPickup_dp(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        int[][][] dp = new int[r][c][c];

        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        // Base case: Fill the last row
        for (int j1 = 0; j1 < c; j1++) {
            for (int j2 = 0; j2 < c; j2++) {
                if (j1 == j2) {
                    dp[r - 1][j1][j2] = grid[r - 1][j1]; // Both agents at the same column
                } else {
                    dp[r - 1][j1][j2] = grid[r - 1][j1] + grid[r - 1][j2]; // Different columns
                }
            }
        }

        // Fill the DP table from bottom to top
        for (int i = r - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < c; j1++) { // Agent 1's position
                for (int j2 = 0; j2 < c; j2++) { // Agent 2's position
                    int maxCherries = Integer.MIN_VALUE;

                    // Explore all moves for both agents
                    for (int dj1 = -1; dj1 <= 1; dj1++) { // Moves for agent 1: left, stay, right
                        for (int dj2 = -1; dj2 <= 1; dj2++) { // Moves for agent 2: left, stay, right
                            int newJ1 = j1 + dj1;
                            int newJ2 = j2 + dj2;

                            if (newJ1 >= 0 && newJ1 < c && newJ2 >= 0 && newJ2 < c) {
                                int cherries = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                                cherries += dp[i + 1][newJ1][newJ2];
                                maxCherries = Math.max(maxCherries, cherries);
                            }
                        }
                    }

                    dp[i][j1][j2] = maxCherries; // Store the result in the table
                }
            }
        }

        return dp[0][0][c - 1];
    }

}

