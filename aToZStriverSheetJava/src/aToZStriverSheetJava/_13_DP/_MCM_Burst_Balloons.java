package aToZStriverSheetJava._13_DP;

import java.util.*;

//link - https://leetcode.com/problems/burst-balloons/

public class _MCM_Burst_Balloons {

//    ------ RECURSION

    int[][] dp ;

    public int solve(int i, int j, LinkedList<Integer> coins){
        if(i > j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int maxi = (int) -1e9;
        for(int k=i; k<=j; k++){
            int cost = (coins.get(i-1) * coins.get(k) * coins.get(j+1) )
                    + solve(i, k-1, coins) + solve(k+1, j, coins);
            maxi = Math.max(maxi, cost);
        }

        return dp[i][j] = maxi;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        dp = new int[n+2][n+2];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }

        LinkedList<Integer> coins = new LinkedList<>();
        for(int num: nums){
            coins.add(num);
        }
        coins.addFirst(1);
        coins.addLast(1);

        return solve(1, n, coins);
    }


//    ------ DP


    public int maxCoins_dp(int[] nums) {
        int n = nums.length;
        dp = new int[n+2][n+2];
        for(int[] d: dp){
            Arrays.fill(d, 0);
        }

        int[] coins = new int[n + 2];
        coins[0] = coins[n + 1] = 1; // Boundary values
        for (int i = 1; i <= n; i++) {
            coins[i] = nums[i - 1];
        }

        for(int i=n; i>=1; i--){
            for(int j=1; j<=n; j++){
                if(i > j){
                    continue;
                }
                int maxi = (int) -1e9;
                for(int k=i; k<=j; k++){
                    int cost = (coins[i-1] * coins[k] * coins[j+1] )
                            + dp[i][k-1] + dp[k+1][j];
                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }

        return dp[1][n];
    }

}
