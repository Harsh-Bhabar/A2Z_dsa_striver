package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

//link - https://leetcode.com/problems/longest-increasing-subsequence/

public class _LIS_length {

//    ---- recursion

    int[][] dp;

    public int solve(int i, int prev_ind, int[] nums) {
        if (i == nums.length) {
            return 0;
        }

        if (dp[i][prev_ind + 1] != -1) {
            return dp[i][prev_ind + 1];
        }

        // Not taken
        int len = solve(i + 1, prev_ind, nums);

        // Taken
        if (prev_ind == -1 || nums[i] > nums[prev_ind]) {
            len = Math.max(len, 1 + solve(i + 1, i, nums));
        }

        return dp[i][prev_ind + 1] = len;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1][n + 1];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return solve(0, -1, nums);
    }

//    ----- DP


    public int lengthOfLIS_dp(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                // Not take
                int len = dp[i + 1][prev + 1];

                // Take
                if (prev == -1 || nums[i] > nums[prev]) {
                    len = Math.max(len, 1 + dp[i + 1][i + 1]);
                }

                dp[i][prev + 1] = len;
            }
        }

        return dp[0][0];
    }

}
