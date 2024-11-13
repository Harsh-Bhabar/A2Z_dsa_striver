package aToZStriverSheetJava._004_BinarySearch.On_Answer;

import java.util.Arrays;

//link - https://leetcode.com/problems/split-array-largest-sum/

public class AllocateBooks {
    public boolean isSplitPossible(int[] nums, int k, int maxSum){
        int cntSplit = 1;
        int lastSum = nums[0];

        for(int i=1; i<nums.length; i++){
            if(lastSum + nums[i] <= maxSum){
                lastSum = lastSum + nums[i];
            }else{
                cntSplit++;
                lastSum = nums[i];
            }
            if(cntSplit > k){
                return false;
            }
        }

        return true;
    }

    public int splitArray(int[] nums, int k) {
        if(k > nums.length){
            return 0;
        }

        int l = Arrays.stream(nums).max().orElse(1);
        int r = Arrays.stream(nums).sum();
        int ans = -1;

        while(l <= r){
            int mid = l + (r-l)/2;
            if(isSplitPossible(nums, k, mid)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return ans;
    }
}
