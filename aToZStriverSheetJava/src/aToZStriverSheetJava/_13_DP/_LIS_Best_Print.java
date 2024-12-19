package aToZStriverSheetJava._13_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//link - https://www.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/0

public class _LIS_Best_Print {

    public ArrayList<Integer> longestIncreasingSubsequence(int n, int nums[]) {
        int[] dp = new int[n];
        int[] hash = new int[n];

        Arrays.fill(dp, 0);
        int maxi = 0;
        int lastIndex = 0;

        for(int i=0; i<n; i++){
            hash[i] = i;
            for(int prev=0; prev<i; prev++){
                if(nums[prev] < nums[i] && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if(dp[i] > maxi){
                maxi = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(nums[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            ans.add(nums[lastIndex]);
        }

        Collections.reverse(ans);

        return ans;
    }
}
