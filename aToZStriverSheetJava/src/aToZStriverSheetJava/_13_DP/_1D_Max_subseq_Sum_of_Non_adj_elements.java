package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

public class _1D_Max_subseq_Sum_of_Non_adj_elements {

    // ---------- recursive

    int MOD = 1000000007;
    int[] dp;

    public int solve(int n, int[] nums){
        if(n < 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int pick = nums[n] + solve(n-2, nums) ;
        int notPick = 0 + solve(n-1, nums);

        return dp[n] = Math.max(pick, notPick);
    }

    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int n = nums.length;
        int totalSum = 0;

        dp = new int[n];

        for(int[] q: queries){
            nums[q[0]] = q[1];
            Arrays.fill(dp, -1);
            int ans = solve(n-1, nums);
            totalSum = (totalSum + ans) % MOD ;
        }

        return totalSum;
    }

    // ----------------- DP

    public int solve(int[] nums){
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return Math.max(0, nums[0]);
        }

        int prev1 = Math.max(0, nums[0]);
        int prev2 = 0;

        for(int i=1; i<n; i++){
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }


}
