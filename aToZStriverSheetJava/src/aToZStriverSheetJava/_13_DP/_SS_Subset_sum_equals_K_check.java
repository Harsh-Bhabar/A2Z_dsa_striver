package aToZStriverSheetJava._13_DP;

public class _SS_Subset_sum_equals_K_check {

//    ---- recursion
    public static Boolean[][] dp ;

    public static Boolean solve(int i, int target, int[] arr){
        if(target == 0){
            return true;
        }
        if(i == 0){
            return dp[i][target] = (arr[0] == target);
        }
        if(dp[i][target] != null){
            return dp[i][target];
        }
        Boolean notTake = solve(i-1, target, arr);
        Boolean take = false;
        if(arr[i] <= target){
            take = solve(i-1, target-arr[i], arr);
        }

        return dp[i][target] = ( take || notTake );
    }

    static Boolean isSubsetSum(int arr[], int target) {
        int n = arr.length;
        dp = new Boolean[n+1][target+1];

        return solve(n-1, target, arr);
    }

//    -------- DP

    static Boolean isSubsetSum_dp(int arr[], int target) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][target+1];

        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        if(arr[0] <= target){
            dp[0][arr[0]] = true;
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<=target; j++){

                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(arr[i] <= j){
                    take = dp[i-1][j-arr[i]];
                }

                dp[i][j] = take || notTake;
            }
        }

        return dp[n-1][target];
    }

}
