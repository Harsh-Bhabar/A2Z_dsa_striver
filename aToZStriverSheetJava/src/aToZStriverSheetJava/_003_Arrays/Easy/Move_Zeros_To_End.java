package aToZStriverSheetJava._003_Arrays.Easy;

//link - https://leetcode.com/problems/move-zeroes/

public class Move_Zeros_To_End {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return;
        }

        int nonZero = 0;

        for(int i=0; i<n; i++){
            if(nums[i] != 0){
                // if not zero, then put it in place
                nums[nonZero] = nums[i];
                nonZero++;
            }
        }

        // fill the rest with zero
        while(nonZero < n){
            nums[nonZero] = 0;
            nonZero++;
        }
    }
}
