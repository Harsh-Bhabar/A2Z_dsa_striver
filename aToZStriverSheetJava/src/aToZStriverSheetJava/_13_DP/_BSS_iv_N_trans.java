package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

public class _BSS_iv_N_trans {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for(int[][] dd: dp){
            for(int[] d: dd){
                Arrays.fill(d, 0);
            }
        }

        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy<=1; buy++){
                for(int cap=1; cap<=k; cap++){
                    if(buy == 1){
                        dp[i][buy][cap] = Math.max(-prices[i] + dp[i+1][0][cap],
                                0 + dp[i+1][1][cap]);
                    }else{
                        dp[i][buy][cap] = Math.max(prices[i] + dp[i+1][1][cap-1],
                                0 + dp[i+1][0][cap]);
                    }
                }
            }
        }

        return dp[0][1][k];
    }
}
