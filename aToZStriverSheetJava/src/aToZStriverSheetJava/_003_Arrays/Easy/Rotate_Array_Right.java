package aToZStriverSheetJava._003_Arrays.Easy;

//link - https://leetcode.com/problems/rotate-array/description/

public class Rotate_Array_Right {
    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        if(k == 0){
            return;
        }

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
}
