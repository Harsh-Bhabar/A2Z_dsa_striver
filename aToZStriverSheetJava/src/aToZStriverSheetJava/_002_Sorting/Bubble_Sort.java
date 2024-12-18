package aToZStriverSheetJava._002_Sorting;

//Time - O(n^2)
//Space - O(n^2)

public class Bubble_Sort {
    public static void main(String[] args){
        int[] nums = {1, 5, 6, 6, 2, 0};

        for(int i=1; i<nums.length; i++){
            for(int j=0; j<nums.length-1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        for(int i: nums){
            System.out.print(i + " ");
        }
    }
}
