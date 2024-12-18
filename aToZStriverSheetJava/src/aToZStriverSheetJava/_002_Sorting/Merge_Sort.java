package aToZStriverSheetJava._002_Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Sort {

    public static void mergeSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int mid = left + (right-left)/2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid+1, right);

        merge(nums, left, mid, right);
    }

    public static void printArray(int[] nums){
        for(int x: nums){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void merge(int[] nums, int low, int mid, int high){

        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
                right++;
            }
        }

        while(left <= mid){
            temp.add(nums[left]);
            left++;
        }

        while(right <= high){
            temp.add(nums[right]);
            right++;
        }

        for(int i=low; i<=high; i++){
            nums[i] = temp.get(i-low);
        }
//        printArray(nums);
//        System.out.println("Low " + low + " MID " + mid + " high " + high);
    }

    public static void main(String[] args){
        int[] nums = {4, 5, 2, 1, 7, 3, 6};

        mergeSort(nums, 0, nums.length-1);
        System.out.print(Arrays.toString(nums));
    }
}
