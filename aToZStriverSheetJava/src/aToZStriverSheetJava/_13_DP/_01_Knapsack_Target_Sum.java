package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

//https://leetcode.com/problems/target-sum/

public class _01_Knapsack_Target_Sum {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if((Math.abs(target) > sum) || (sum + target) % 2 != 0){
            return 0;
        }

        int k = (sum + target)/2;

        int[][] dp = new int[n][k+1];
        for(int[] a: dp){
            Arrays.fill(a, 0);
        }

        dp[0][0] = 1;
        if(nums[0] <= k){
            dp[0][nums[0]] += 1;
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<=k; j++){
                int nottaken = dp[i-1][j];
                int taken = 0;
                if(nums[i] <= j){
                    taken = dp[i-1][j-nums[i]];
                }
                dp[i][j] = taken + nottaken;
            }
        }

        return dp[n-1][k];
    }
}
