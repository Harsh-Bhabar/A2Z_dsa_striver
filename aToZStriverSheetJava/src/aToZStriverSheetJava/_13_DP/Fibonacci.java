package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

public class Fibonacci {
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
}
