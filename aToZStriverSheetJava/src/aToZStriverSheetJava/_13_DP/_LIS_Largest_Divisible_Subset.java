package aToZStriverSheetJava._13_DP;

import java.util.*;

//link - https://leetcode.com/problems/largest-divisible-subset/

public class _LIS_Largest_Divisible_Subset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        // exact same as LIS but with sort
        Arrays.sort(nums);
        int n = nums.length;

        int[] lisLen = new int[n];
        int[] prevIndex = new int[n];

        Arrays.fill(lisLen, 1);

        int endIndex = 0;
        int maxi = 0;

        for(int i=0; i<n; i++){
            prevIndex[i] = i;
            for(int prev=0; prev<i; prev++){
                if(nums[i] % nums[prev] == 0 && 1 + lisLen[prev] > lisLen[i]){
                    lisLen[i] = 1 + lisLen[prev];
                    prevIndex[i] = prev;
                }
            }
            if(lisLen[i] > maxi){
                maxi = lisLen[i];
                endIndex = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        int currIndex = endIndex;

        while(prevIndex[currIndex] != currIndex){
            ans.add(nums[currIndex]);
            currIndex = prevIndex[currIndex];
        }

        ans.add(nums[currIndex]);

        Collections.reverse(ans);

        return ans;
    }
}
