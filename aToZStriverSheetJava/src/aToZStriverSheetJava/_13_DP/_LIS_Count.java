package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

//link - https://leetcode.com/problems/number-of-longest-increasing-subsequence/

public class _LIS_Count {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] lisLen = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(lisLen, 1);
        Arrays.fill(cnt, 1);

        int maxi = 0;

        for(int i=0; i<n; i++){
            for(int prev=0; prev<i; prev++){
                if(nums[prev] < nums[i]){
                    if(1 + lisLen[prev] > lisLen[i]){
                        lisLen[i] = 1 + lisLen[prev];
                        //inherit
                        cnt[i] = cnt[prev];
                    }
                    else if(1 + lisLen[prev] == lisLen[i]){
                        // increase
                        cnt[i] += cnt[prev];
                    }
                }
            }
            maxi = Math.max(maxi, lisLen[i]); // len of lis
        }

        int nos = 0;
        for(int i=0; i<n; i++){
            if(lisLen[i] == maxi) {
                nos += cnt[i];
            }
        }

        return nos;
    }
}
