package aToZStriverSheetJava._002_Sorting;

public class Bubble_Sort_Recursive {

    public static void RecursiveBubbleSort(int[] nums, int n){
        if(n==1){
            return;
        }
        // place the last one to correct position
        for(int i=0; i<n-1; i++){
            if(nums[i] > nums[i+1]){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }

        RecursiveBubbleSort(nums, n-1);
    }

    public static void printArray(int[] nums){
        for(int x: nums){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] nums = {4, 5, 1, 3, 2};
        printArray(nums);
        RecursiveBubbleSort(nums, nums.length);
        printArray(nums);
    }
}
