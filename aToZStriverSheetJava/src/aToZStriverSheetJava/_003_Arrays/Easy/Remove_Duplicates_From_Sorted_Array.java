package aToZStriverSheetJava._003_Arrays.Easy;

//link - https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class Remove_Duplicates_From_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return 1;
        }

        int correct = 0;

        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[correct]){
                correct++;
                nums[correct] = nums[i];
            }
        }

        return correct+1;
    }
}
