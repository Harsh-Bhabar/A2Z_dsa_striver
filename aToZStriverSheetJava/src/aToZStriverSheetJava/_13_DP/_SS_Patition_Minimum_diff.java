package aToZStriverSheetJava._13_DP;

//link - https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

public class _SS_Patition_Minimum_diff {

    public int minDifference(int nums[]) {
        // Your code goes here
        int n = nums.length;
        int sum = 0;
        for(int i: nums){
            sum += i;
        }

        int k = sum/2;
        boolean[][] dp = new boolean[n][k+1];

        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }
        if(nums[0] <= k){
            dp[0][nums[0]] = true;
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<=k; j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(nums[i] <= j){
                    take = dp[i-1][j-nums[i]];
                }

                dp[i][j] = take || notTake;
            }
        }

        int targetVal = -1;
        for(int i=k; i>=0; i--){
            if(dp[n-1][i] == true){
                targetVal = i;
                break;
            }
        }

        return Math.abs(sum - (2 * targetVal));
    }
}
