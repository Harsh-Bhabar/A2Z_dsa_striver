package aToZStriverSheetJava._13_DP;

//link - https://www.geeksforgeeks.org/problems/rod-cutting0840/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

import java.util.Arrays;

public class _Unbounded_Knapsack_Rod_Cutting {
//    ------ recursion

    int[][] dp ;
    public int solve(int i, int N, int[] price){
        if(i == 0){
            return N * price[0];
        }
        if(dp[i][N] != -1){
            return dp[i][N];
        }
        int notTaken = solve(i-1, N, price);
        int taken = 0;
        int rodLen = i + 1;
        if(rodLen <= N){
            taken = price[i] + solve(i, N-rodLen, price);
        }
        return dp[i][N] = Math.max(taken, notTaken);
    }

    public int cutRod(int[] price) {
        int n = price.length;
        dp = new int[n][n+1];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }

        return solve(n-1, n, price);
    }

//    ----- DP


    public int cutRod_2(int[] price) {
        int n = price.length;
        dp = new int[n][n+1];

        for(int rodLen=0; rodLen<=n; rodLen++){
            dp[0][rodLen] = rodLen * price[0];
        }

        for(int i=1; i<n; i++){
            for(int len=0; len<=n; len++){
                int notTaken = dp[i-1][len];
                int taken = 0;
                int rodLen = i+1;
                if(rodLen <= len){
                    taken = price[i] + dp[i][len-rodLen];
                }
                dp[i][len] = Math.max(taken, notTaken);
            }
        }

        return dp[n-1][n];
    }

}
