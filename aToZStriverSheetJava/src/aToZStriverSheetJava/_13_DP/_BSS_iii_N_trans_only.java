package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

public class _BSS_iii_N_trans_only {

//    ----- recursion

    int[][][] dp;

    public int solve(int i, int buy, int cap, int[] prices){
        if(cap == 0){
            return 0;
        }
        if(i == prices.length){
            return 0;
        }
        if(dp[i][buy][cap] != -1){
            return dp[i][buy][cap];
        }
        if(buy == 1){
            return dp[i][buy][cap] = Math.max(-prices[i] + solve(i+1, 0, cap, prices),
                    0 + solve(i+1, 1, cap, prices));
        }else{
            return dp[i][buy][cap] = Math.max(prices[i] + solve(i+1, 1, cap-1, prices),
                    0 + solve(i+1, 0, cap, prices));
        }
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2][3];

        for(int[][] dd: dp){
            for(int[] d: dd){
                Arrays.fill(d, -1);
            }
        }

        return solve(0, 1, 2, prices);
    }


//    ------- DP

    public int maxProfit_2(int[] prices) {
        int n = prices.length;
        dp = new int[n+1][2][3];

        for(int[][] dd: dp){
            for(int[] d: dd){
                Arrays.fill(d, 0);
            }
        }

        for(int i=n-1; i>=0; i--){
            for(int buy=0; buy <= 1; buy++){
                for(int cap=1; cap <= 2; cap++){
                    if(buy == 1){
                        dp[i][buy][cap] = Math.max(-prices[i] + dp[i+1][0][cap],
                                dp[i+1][1][cap]) ;
                    }else{
                        dp[i][buy][cap] = Math.max(prices[i] + dp[i+1][1][cap-1]
                                , dp[i+1][0][cap]);
                    }
                }
            }
        }

        return dp[0][1][2];
    }



}
