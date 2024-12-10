package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

public class Fibonacci {

    // memorize - bottom-up
    int[] dp;

    public int calculate(int n){
        if(n <= 1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = calculate(n-1) + calculate(n-2);
    }

    public int fib(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return calculate(n);
    }

    // top-down

    public int fib_2(int n) {
        if(n <= 1){
            return n;
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
