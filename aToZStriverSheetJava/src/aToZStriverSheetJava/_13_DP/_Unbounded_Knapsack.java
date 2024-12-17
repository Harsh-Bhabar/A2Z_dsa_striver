package aToZStriverSheetJava._13_DP;

//link - https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

import java.util.Arrays;

public class _Unbounded_Knapsack {

//    ----- recursion

    static int[][] dp;
    static int solve(int i, int cap, int[] val, int[] wt){
        if(i==0){
            return ( cap / wt[0] ) * val[0];
        }
        if(dp[i][cap] != -1){
            return dp[i][cap];
        }
        int notTaken = solve(i-1, cap, val, wt);
        int taken = 0;
        if(wt[i] <= cap){
            taken = val[i] + solve(i, cap-wt[i], val, wt);
        }

        return dp[i][cap] = Math.max(taken, notTaken);
    }

    static int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        dp = new int[n][capacity+1];
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }

        return solve(n-1, capacity, val, wt);
    }


//    ------- DP

    static int knapSack_dp(int val[], int wt[], int capacity) {
        int n = val.length;
        int[][] dp = new int[n][capacity+1];

        for(int w=0; w<=capacity; w++){
            dp[0][w] = (w / wt[0]) * val[0];
        }

        for(int i=1; i<n; i++){
            for(int w=0; w<=capacity; w++){
                int notTaken = dp[i-1][w];
                int taken = 0;
                if(wt[i] <= w){
                    taken = val[i] + dp[i][w-wt[i]];
                }
                dp[i][w] = Math.max(taken, notTaken);
            }
        }

        return dp[n-1][capacity];
    }

}
