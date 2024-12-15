package aToZStriverSheetJava._13_DP;

//link - https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

public class _01_Knapsack {
//    ----- recursion
    public static int[][] dp;

    static public int solve(int i, int cap, int[] val, int[] wt){
        if(i == 0){
            return (wt[i] <= cap) ? val[i] : 0;
        }
        if(dp[i][cap] != -1){
            return dp[i][cap];
        }

        int notTaken = solve(i-1, cap, val, wt);
        int taken = Integer.MIN_VALUE;
        if(wt[i] <= cap){
            taken = val[i] + solve(i-1, cap-wt[i], val, wt);
        }

        return dp[i][cap] = Math.max(taken, notTaken);
    }

    static int knapSack(int capacity, int val[], int wt[]) {
        int n = val.length;
        dp = new int[n][capacity+1];
        for(int i=0; i<n; i++){
            for(int j=0; j<=capacity; j++){
                dp[i][j] = -1;
            }
        }

        return solve(n-1, capacity, val, wt);
    }

//    --------- DP

    static int knapSack_2(int cap, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[n][cap+1];

        for(int w=0; w<=cap; w++){
            dp[0][w] = (wt[0] <= w) ? val[0] : 0;
        }

        for(int i=1; i<n; i++){
            for(int w=0; w<=cap; w++){
                int notTaken = dp[i-1][w];
                int taken = Integer.MIN_VALUE;
                if(wt[i] <= w){
                    taken = val[i] + dp[i-1][w-wt[i]];
                }

                dp[i][w] = Math.max(taken, notTaken);
            }
        }

        return dp[n-1][cap];
    }
}
