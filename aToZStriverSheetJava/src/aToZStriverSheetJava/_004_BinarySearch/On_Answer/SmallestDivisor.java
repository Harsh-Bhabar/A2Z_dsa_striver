package aToZStriverSheetJava._004_BinarySearch.On_Answer;

import java.util.Arrays;

//link - https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

public class SmallestDivisor {
    public int findSumWithDiv(int[] nums, int div){
        int total = 0;
        for(int x: nums){
            total += Math.ceil((double) x / div);
        }
        return total;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = Arrays.stream(nums).max().orElse(1);
        int ans = -1;

        while(l <= r){
            int mid = l + (r-l)/2;
            int currSum = findSumWithDiv(nums, mid);
            if(currSum <= threshold){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return ans;
    }
}
