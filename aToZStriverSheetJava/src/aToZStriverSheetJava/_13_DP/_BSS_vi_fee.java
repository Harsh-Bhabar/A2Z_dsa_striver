package aToZStriverSheetJava._13_DP;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

public class _BSS_vi_fee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;

        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                if(buy == 1){
                    dp[i][buy] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
                }else{
                    dp[i][buy] = Math.max(prices[i] - fee + dp[i+1][1], dp[i+1][0]);
                }
            }
        }

        return dp[0][1];
    }
}
