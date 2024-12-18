package aToZStriverSheetJava._003_Arrays.Easy;

import java.util.HashMap;

//link - https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=longest-sub-array-with-sum-k

public class Longest_Subarray_With_Sum_K {
    public static int lenOfLongSubarr(int nums[], int N, int k) {
        int pSum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> pMap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            pSum += nums[i];

            if(pSum == k){
                maxLen = i+1;
            }

            if(pMap.containsKey(pSum-k)){
                maxLen = Math.max(maxLen, i-pMap.get(pSum-k));
            }

            if(!pMap.containsKey(pSum)){
                pMap.put(pSum, i);
            }
        }

        return maxLen;
    }
}
