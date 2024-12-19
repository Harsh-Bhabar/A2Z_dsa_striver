package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

//link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

public class _BSS_ii_any_tran {
//    ------ recursion

    int[][] dp;
    public int solve(int i, int buy, int[] prices){
        if(i == prices.length){
            return 0;
        }
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        if(buy == 1){
            // take n notTake
            return dp[i][buy] = Math.max(
                    -prices[i] + solve(i+1, 0, prices),
                    0 + solve(i+1, 1, prices)
            );
        }else{
            return dp[i][buy] = Math.max(
                    prices[i] + solve(i+1, 1, prices),
                    0 + solve(i+1, 0, prices)
            );
        }
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }

        return solve(0, 1, prices);
    }

//    ------- DP


    public int maxProfit_dp(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        dp[n][0] = dp[n][1] = 0;

        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                long profit = 0;
                if(buy == 1){
                    profit = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
                }else{
                    profit = Math.max(prices[i] + dp[i+1][1], dp[i+1][0]);
                }
                dp[i][buy] = (int) profit;
            }
        }

        return dp[0][1];
    }
}
