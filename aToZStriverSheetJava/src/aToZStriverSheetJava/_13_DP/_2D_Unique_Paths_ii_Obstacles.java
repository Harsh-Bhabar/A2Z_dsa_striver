package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

public class _2D_Unique_Paths_ii_Obstacles {
//    ------ RECURSION
    int[][] dp;

    public int solve(int m, int n, int[][] grid){
        if(m == 0 && n == 0){
            return grid[0][0] == 1 ? 0 : 1; // base obstacle
        }
        if(m < 0 || n < 0 || grid[m][n] == 1){
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        int up = solve(m-1, n, grid);
        int left = solve(m, n-1, grid);

        return dp[m][n] = up + left;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        dp = new int[m][n];
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }

        return solve(m-1, n-1, obstacleGrid);
    }

//    -------- DP


    public int uniquePathsWithObstacles_2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // first row first col
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0; // Obstacle cell has 0 paths
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

}
