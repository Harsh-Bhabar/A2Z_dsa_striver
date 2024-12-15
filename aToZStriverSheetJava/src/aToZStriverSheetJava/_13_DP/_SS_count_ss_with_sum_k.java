package aToZStriverSheetJava._13_DP;

//https://www.naukri.com/code360/problems/count-subsets-with-sum-k_3952532?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION

public class _SS_count_ss_with_sum_k {

    static int MOD = 1_000_000_007;

    public static int findWays(int nums[], int k) {
        int n = nums.length;
        long[][] dp = new long[n][k + 1];

        // Base case: It's always possible to form a sum of 0
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        // Handle the first element explicitly
        if (nums[0] <= k) {
            dp[0][nums[0]] = 1;
        }

        // Fill the DP table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                long notTaken = dp[i - 1][j]; // Case where current element is not taken
                long taken = 0;
                if (nums[i] <= j) {
                    taken = dp[i - 1][j - nums[i]]; // Case where current element is taken
                }

                dp[i][j] = (notTaken + taken) % MOD; // Apply modulo during computation
            }
        }

        return (int) dp[n - 1][k];
    }
}
