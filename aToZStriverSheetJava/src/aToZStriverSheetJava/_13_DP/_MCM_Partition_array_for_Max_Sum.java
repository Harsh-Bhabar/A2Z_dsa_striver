package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

//link - https://leetcode.com/problems/partition-array-for-maximum-sum/

public class _MCM_Partition_array_for_Max_Sum {
//    ------ recursion

    int[] dp;

    public int solve(int i, int[] nums, int k){
        if(i == nums.length){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int maxAns = 0;

        for(int j=i; j< Math.min(nums.length, i+k); j++){
            len++;
            maxi = Math.max(maxi, nums[j]);
            int sum = len * maxi + solve(j+1, nums, k);
            maxAns = Math.max(maxAns, sum);
        }

        return dp[i] = maxAns;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        dp = new int[n+1];
        Arrays.fill(dp, -1);

        return solve(0, arr, k);
    }

//    ------ DP


    public int maxSumAfterPartitioning_2(int[] arr, int k) {
        int n = arr.length;
        dp = new int[n+1];
        Arrays.fill(dp, 0);

        for(int i=n-1; i>=0; i--){
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int maxAns = 0;
            for(int j=i; j<Math.min(n, i+k); j++){
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = len * maxi + dp[j+1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[i] = maxAns;
        }

        return dp[0];
    }

}
