package aToZStriverSheetJava._13_DP;

//link - https://leetcode.com/problems/coin-change-ii/

import java.util.Arrays;

public class _01_knapsack_Coin_change_ii {

//    ------- Recursion

    int[][] dp;

    public int solve(int i, int amt, int[] coins){
        if(amt == 0){
            return 1;
        }
        if(i < 0){
            return 0;
        }
        if(dp[i][amt] != -1){
            return dp[i][amt];
        }
        int notTaken = solve(i-1, amt, coins);
        int taken = 0;
        if(coins[i] <= amt){
            taken = solve(i, amt-coins[i], coins);
        }
        return dp[i][amt] = taken + notTaken;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n][amount+1];
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }

        return solve(n-1, amount, coins);
    }

//    ------- DP


    public int change_dp(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] a : dp){
            Arrays.fill(a, 0);
        }

        for(int i=0; i<n; i++){
            dp[i][0] = 1;
        }

        for(int j=0; j<=amount; j++){
            if(j % coins[0] == 0){
                dp[0][j] = 1;
            }
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=amount; j++){
                int notTaken = dp[i-1][j];
                int taken = 0;
                if(coins[i] <= j){
                    taken = dp[i][j-coins[i]];
                }
                dp[i][j] = taken + notTaken;
            }
        }

        return dp[n-1][amount];
    }

}
