package aToZStriverSheetJava._007_Recursion.Basics;

import java.util.Arrays;

public class ReverseArray {
    public static int[] reverse(int[] nums, int l, int r){
        if(l >= r){
            return nums;
        }

        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;

        return reverse(nums, l+1, r-1);
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5};
        int[] reversed = reverse(nums, 0, nums.length-1);

        System.out.println(Arrays.toString(reversed));
    }
}
