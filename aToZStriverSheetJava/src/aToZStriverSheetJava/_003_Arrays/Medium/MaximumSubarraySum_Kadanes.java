package aToZStriverSheetJava._003_Arrays.Medium;

public class MaximumSubarraySum_Kadanes {
    public int kadanes(int[] nums){
        int currSum = nums[0];
        int ans = nums[0];

        for(int i=1; i<nums.length; i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            ans = Math.max(currSum, ans);
        }

        return ans;
    }

    public int maxSubArray(int[] nums) {
        return kadanes(nums);
    }
}
