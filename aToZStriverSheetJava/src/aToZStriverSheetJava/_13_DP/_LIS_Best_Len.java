package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

public class _LIS_Best_Len {
//    -------- n^2  + n

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 0;

        for(int i=0; i<n; i++){
            for(int prev=0; prev<i; prev++){
                if(nums[prev] < nums[i]){
                    dp[i] = Math.max(dp[i], 1+dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        return maxi;
    }

}
