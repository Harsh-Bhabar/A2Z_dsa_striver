package aToZStriverSheetJava._13_DP;

//link - https://leetcode.com/problems/house-robber-ii/

public class _1D_Max_subseq_Sum_of_Non_adj_ele_CIRCULAR {
    public int solve(int start, int end, int[] nums){
        int prev2 = 0;
        int prev1 = 0;

        for(int i=start; i<=end; i++){
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        return Math.max(solve(0, n-2, nums), solve(1, n-1, nums));
    }
}
