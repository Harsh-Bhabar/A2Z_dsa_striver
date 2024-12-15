package aToZStriverSheetJava._13_DP;

//link - https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

public class _SS_Partition_diff_COUNT {

    int countPartitions(int[] nums, int diff) {
        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++)
            sum += nums[i];

        if (diff > sum)
            return 0;

        if ((diff + sum) % 2 != 0)
            return 0;

        int s2 = (diff + sum) / 2;

        int[][] dp = new int[n+1][s2+1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int j = 1; j <= s2; j++)
            dp[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= s2; j++) {
                if (nums[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j]
                            + dp[i - 1][j - nums[i - 1]];
            }
        }

        return dp[n][s2];
    }
}
