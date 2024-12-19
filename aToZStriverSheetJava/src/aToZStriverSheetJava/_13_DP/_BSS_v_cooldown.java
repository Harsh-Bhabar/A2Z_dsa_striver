package aToZStriverSheetJava._13_DP;

//link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

public class _BSS_v_cooldown {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;

        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                if(buy == 1){
                    dp[i][buy] = Math.max(-prices[i] + dp[i+1][0],
                            0 + dp[i+1][1]);
                }else{
                    int sell = (i+2 < n) ? prices[i] + dp[i+2][1] : prices[i];  // only change here, we skip one day
                    dp[i][buy] = Math.max(sell, 0 + dp[i+1][0]);
                }
            }
        }

        return dp[0][1];
    }
}
