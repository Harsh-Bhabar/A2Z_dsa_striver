package aToZStriverSheetJava._003_Arrays.Medium;

import java.sql.Array;

public class MaximumSubarraySum_Kadanes {
    public static void printKadanes(int[] nums){
        int ans = nums[0];
        int currSum = nums[0];
        int ansStart = 0;
        int ansEnd = 0;
        int tempStart = 0;

        for(int i=1; i<nums.length; i++){
            if(nums[i] > currSum + nums[i]){
                currSum = nums[i];
                tempStart = i;
            }else{
                currSum += nums[i];
            }
            if(currSum > ans){
                ansEnd = i;
                ansStart = tempStart;
                ans = currSum;
            }
        }

        for(int i=ansStart; i<=ansEnd; i++){
            System.out.print(nums[i] + " ");
        }System.out.println();
    }

    public static int kadanes(int[] nums){
        int currSum = nums[0];
        int ans = nums[0];

        for(int i=1; i<nums.length; i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            ans = Math.max(currSum, ans);
        }

        return ans;
    }

//    public int maxSubArray(int[] nums) {
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4} ;
        printKadanes(nums);
        System.out.println(kadanes(nums));
    }
}
