package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

public class _1D_Frog_jump {
    static int[] dp ;


    // memorization
    public static int solve(int n, int[] heights){
        if(n == 0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int left = solve(n-1, heights) + Math.abs(heights[n] - heights[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1){
            right = solve(n-2, heights) + Math.abs(heights[n] - heights[n-2]);
        }
        return dp[n] = Math.min(left, right);
    }
    public static int frogJump(int n, int heights[]) {
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n-1, heights);
    }

    // DP
    public static int frogJump_dp(int n, int heights[]) {
        dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int i=1; i<n; i++){
            int one = dp[i-1] + Math.abs(heights[i]-heights[i-1]);
            int second = Integer.MAX_VALUE;
            if(i > 1){
                second = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            }

            dp[i] = Math.min(one, second);
        }

        return dp[n-1];
    }
}
