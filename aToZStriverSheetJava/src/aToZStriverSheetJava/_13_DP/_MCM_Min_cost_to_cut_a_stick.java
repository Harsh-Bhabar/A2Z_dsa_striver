package aToZStriverSheetJava._13_DP;

import java.util.*;

//link - https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/

public class _MCM_Min_cost_to_cut_a_stick {

//    --- recursion

    class Solution {

        // Memoization table to store the results of subproblems
        private int[][] dp;

        // Helper function to solve the minimum cost of cutting problem
        public int solve(int i, int j, List<Integer> cuts) {
            // Base case: if the segment has no cuts to be made
            if (i > j) {
                return 0;
            }

            // Check if the result is already computed
            if (dp[i][j] != -1) {
                return dp[i][j];
            }

            int mini = Integer.MAX_VALUE; // Initialize minimum cost as maximum possible value

            // Try making a cut at every position between indices i and j
            for (int k = i; k <= j; k++) {
                // Calculate the cost of the current cut
                int cost = cuts.get(j + 1) - cuts.get(i - 1)
                        + solve(i, k - 1, cuts) // Cost of left subsegment
                        + solve(k + 1, j, cuts); // Cost of right subsegment

                // Update the minimum cost
                mini = Math.min(mini, cost);
            }

            // Store the result in the memoization table and return
            return dp[i][j] = mini;
        }

        public int minCost(int n, int[] cuts) {
            int c = cuts.length; // Number of cuts

            // Create a new list to include boundary cuts (0 and n)
            List<Integer> newCuts = new ArrayList<>();
            for (int num : cuts) {
                newCuts.add(num);
            }
            newCuts.add(0); // Add the starting boundary
            newCuts.add(n); // Add the ending boundary

            // Sort the cuts to ensure logical order
            Collections.sort(newCuts);

            // Initialize the memoization table
            dp = new int[c + 2][c + 2]; // Size depends on the number of cuts + boundaries
            for (int[] row : dp) {
                Arrays.fill(row, -1); // Fill with -1 to indicate uncomputed values
            }

            // Solve the problem for the entire range of cuts
            return solve(1, c, newCuts);
        }
    }


//    ------- DP


    public int minCost_dp(int n, int[] cuts) {
        int c = cuts.length;

        List<Integer> newCuts = new ArrayList<>();
        for(int i: cuts){
            newCuts.add(i);
        }
        newCuts.add(0);
        newCuts.add(n);
        Collections.sort(newCuts);

        int[][] dp = new int[c+2][c+2];
        for(int[] d: dp){
            Arrays.fill(d, 0);
        }

        for(int i=c; i>=1; i--){
            for(int j=1; j<=c; j++){
                if(i > j){
                    continue;
                }
                int mini = Integer.MAX_VALUE;

                for(int k=i; k<=j; k++){
                    int cost = newCuts.get(j+1) - newCuts.get(i-1) +
                            dp[i][k-1] +
                            dp[k+1][j];
                    mini = Math.min(mini, cost);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][c];

    }

}
