package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

public class Frog_jump {
    static int[] dp ;

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
}
