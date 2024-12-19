package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

//link - https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1

public class _MCM_min_steps {
//    ---- recursion
    static int[][] dp;

    public static int solve(int i, int j, int[] arr){
        if(i == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int mini = (int) 1e9;

        for(int k=i; k<=j-1; k++){
            int steps = arr[i-1] * arr[k] * arr[j]
                    + solve(i, k, arr)
                    + solve(k+1, j,arr);
            if(steps < mini){
                mini = steps;
            }
        }

        return dp[i][j] = mini;
    }

    static int matrixMultiplication(int arr[]) {
        int n = arr.length;

        dp = new int[n][n];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        return solve(1, n-1, arr);
    }


//    ----- dp


    static int matrixMultiplication_dp(int arr[]) {
        int n = arr.length;

        int[][] dp = new int[n][n];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }

        for(int i=1; i<n; i++){
            dp[i][i] = 0;
        }

        for(int i=n-1; i>=1; i--){
            for(int j=i+1; j<n; j++){
                int mini = (int) 1e9;

                for(int k=i; k<=j-1; k++){
                    int steps = arr[i-1] * arr[k] * arr[j] +
                            dp[i][k] +
                            dp[k+1][j];
                    if(steps < mini){
                        mini = steps;
                    }
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][n-1];
    }

}
