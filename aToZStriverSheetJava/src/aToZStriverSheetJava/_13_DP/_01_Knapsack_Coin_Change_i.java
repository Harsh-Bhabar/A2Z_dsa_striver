package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

public class _01_Knapsack_Coin_Change_i {
//    ---- recursion

    int[][] dp ;

    public int solve(int i, int amt, int[] coins){
        if(amt == 0){
            return 0;
        }
        if(i == 0){
            return (amt % coins[i] == 0) ? amt / coins[i] : (int) 1e9;
        }

        if(dp[i][amt] != -1){
            return dp[i][amt];
        }

        int notTaken = solve(i-1, amt, coins);

        int taken = (int) 1e9;
        if(coins[i] <= amt){
            taken = 1 + solve(i, amt-coins[i], coins);
        }

        return dp[i][amt] = Math.min(taken, notTaken);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n][amount+1];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        int ans = solve(n-1, amount, coins);
        return ans == (int) 1e9 ? -1 : ans;
    }

//    ---- DP

    public int coinChange_dp(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int amt=0; amt<=amount; amt++){
            if(amt % coins[0] == 0){
                dp[0][amt] = amt / coins[0];
            }else{
                dp[0][amt] = (int) 1e9;
            }
        }

        for(int i=1; i<n; i++){
            for(int amt = 1; amt <= amount; amt++){
                int notTaken = dp[i-1][amt];
                int taken = (int) 1e9;
                if(coins[i] <= amt){
                    taken = 1 + dp[i][amt-coins[i]];
                }
                dp[i][amt] = Math.min(taken, notTaken);
            }
        }

        return dp[n-1][amount] == (int) 1e9 ? -1 : dp[n-1][amount];
    }

}
