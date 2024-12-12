package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

public class _2D_Activity_Training_Non_Adj {
    // -------- recursive
    static int[][] dp ;

    public static int solve(int day, int last, int[][] points){
        if(day < 0){
            return 0;
        }

        if(dp[day][last] != -1){
            return dp[day][last];
        }

        if(day == 0){
            int maxi = 0;
            for(int task=0; task<3; task++){
                if(task != last){
                    maxi = Math.max(maxi, points[day][task]);
                }
            }
            return dp[day][last] = maxi;
        }
        int maxi = 0;
        for(int task=0; task<3; task++){
            if(task != last){
                maxi = Math.max(maxi, points[day][task] + solve(day-1, task, points));
            }
        }
        return dp[day][last] = maxi;
    }

    public static int ninjaTraining(int n, int[][] points) {
        dp = new int[n][4];
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }
        return solve(n-1, 3, points);
    }


//    --------- DP

    public static int ninjaTraining_2(int n, int[][] points) {
        int[][] dp = new int[n][3];

        for(int i = 0; i < 3; i++) {
            dp[0][i] = points[0][i];
        }

        for(int day = 1; day < n; day++) {
            for(int last = 0; last < 3; last++) {
                dp[day][last] = 0;

                for(int prev = 0; prev < 3; prev++) {
                    if(last != prev) {
                        dp[day][last] = Math.max(dp[day][last], points[day][last] + dp[day - 1][prev]);
                    }
                }
            }
        }

        return Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }

}
