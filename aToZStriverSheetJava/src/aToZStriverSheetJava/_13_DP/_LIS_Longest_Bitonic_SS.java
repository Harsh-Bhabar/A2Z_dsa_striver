package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

//link - https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1

public class _LIS_Longest_Bitonic_SS {

    public static int LongestBitonicSequence(int n, int[] nums) {
        int[] lisLen = new int[n];
        int[] ldsLen = new int[n];

        Arrays.fill(lisLen, 1);
        Arrays.fill(ldsLen, 1);

        for(int i=0; i<n; i++){
            for(int prev=0; prev<i; prev++){
                if(nums[prev] < nums[i] && 1 + lisLen[prev] > lisLen[i]){
                    lisLen[i] = 1 + lisLen[prev];
                }
            }
        }

        for(int i=n-1; i>=0; i--){
            for(int next=n-1; next>i; next--){
                if(nums[next] < nums[i] && 1 + ldsLen[next] > ldsLen[i]){
                    ldsLen[i] = 1 + ldsLen[next];
                }
            }
        }

        int maxi = 0;

        for(int i=0; i<n; i++){
            // System.out.println(lisLen[i] + "  " + ldsLen[i]);
            if(ldsLen[i] > 1 && lisLen[i] > 1){
                maxi = Math.max(maxi, lisLen[i] + ldsLen[i] - 1);
            }
        }

        return maxi;
    }
}
