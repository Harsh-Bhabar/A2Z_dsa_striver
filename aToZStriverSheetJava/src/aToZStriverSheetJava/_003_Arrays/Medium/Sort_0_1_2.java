package aToZStriverSheetJava._003_Arrays.Medium;

//link - https://leetcode.com/problems/sort-colors/description/

public class Sort_0_1_2 {
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {

        int zero = 0;
        int two = nums.length-1;
        int i = 0;

        while(i <= two){
            if(nums[i] == 0){
                swap(nums, i, zero);
                i++;
                zero++;
            }
            else if(nums[i] == 2){
                swap(nums, i, two);
                two--;
            }
            else{
                i++;
            }
        }
    }
}
