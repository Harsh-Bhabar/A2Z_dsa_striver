package aToZStriverSheetJava._002_Sorting;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int l, int r, int[] nums){
        if(l < r){
            int mid = l + (r-l)/2;
            // sort first and second half
            mergeSort(l, mid, nums);
            mergeSort(mid+1, r, nums);
            // merge sorted halves
            merge(l, mid, r, nums);
        }
    }

    public static void merge(int l, int mid, int r, int[] nums){
        // sizes of subarrays to be merged
        int n1 = mid - l + 1;
        int n2 = r - mid;

        // create temp arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // copy data
        for(int i=0; i<n1; i++){
            left[i] = nums[l+i];
        }
        for(int i=0; i<n2; i++){
            right[i] = nums[mid+1 + i];
        }

        // merge the two temp array
        int i=0, j=0;
        int k = l; // initial index of merged subarray

        while (i < n1 && j < n2){
            if(left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            } else{
                nums[k] = right[j];
                j++;
            }
            k++;
        }

        // copy remaining elements
        while(i < n1){
            nums[k] = left[i];
            i++;
            k++;
        }
        while(j < n2){
            nums[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args){
        int[] nums = {1,4, 5, 2, 7, 3, 6};

        mergeSort(0, nums.length-1, nums);

        System.out.print(Arrays.toString(nums));
    }
}
