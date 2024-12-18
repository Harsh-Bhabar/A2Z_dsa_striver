package aToZStriverSheetJava._002_Sorting;

public class Insertion_Sort_Recursive {

    public static void printArray(int[] nums){
        for(int x: nums){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void InsertionSortRec(int[] nums, int n){
        if(n <= 1){
            return;
        }
        InsertionSortRec(nums, n-1);

        int last = nums[n-1];
        int j = n - 2;

        // Move elements of arr[0..n-2], that are greater than last, to one position ahead of their current position
        while(j >= 0 && nums[j] > last) {
            nums[j+1] = nums[j];
            j--;
        }

        nums[j+1] = last;
    }

    public static void main(String[] args){
        int[] nums = {4, 5, 2, 1, 3};
        printArray(nums);
        InsertionSortRec(nums, nums.length);
        printArray(nums);
    }
}
