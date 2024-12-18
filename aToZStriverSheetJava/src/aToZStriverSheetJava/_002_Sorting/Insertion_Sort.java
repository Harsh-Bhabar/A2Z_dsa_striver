package aToZStriverSheetJava._002_Sorting;

public class Insertion_Sort {
    public static void main(String[] args){
        int[] nums = {5, 3, 2, 4, 1, 6, 7, 8, 9};

        for(int i=1; i<nums.length; i++){
            int j = i;
            while(j > 0 && nums[j-1] > nums[j]){
                int temp = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = temp;
                j -= 1;
            }
        }

        for(int i: nums){
            System.out.print(i + " ");
        }
    }
}
