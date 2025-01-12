package aToZStriverSheetJava._13_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//link - https://www.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/0

public class _LIS_Best_Print {

    public List<Integer> lexicographicallySmallestLIS(int n, int[] arr) {
        // dp[i] stores the length of LIS ending at index i
        int[] dp = new int[n];
        // prev[i] stores the previous index in the LIS ending at index i
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        // Build the LIS dynamically
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
                // For lexicographical order, if lengths are same, choose smaller index
                else if (arr[i] > arr[j] && dp[i] == dp[j] + 1 && prev[i] > j) {
                    prev[i] = j;
                }
            }
        }

        // Find the index of the maximum LIS length
        int maxLength = 0, lastIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        // Reconstruct the LIS
        List<Integer> lis = new ArrayList<>();
        while (lastIndex != -1) {
            lis.add(arr[lastIndex]);
            lastIndex = prev[lastIndex];
        }

        // The LIS is constructed in reverse order
        Collections.reverse(lis);
        return lis;
    }

}
