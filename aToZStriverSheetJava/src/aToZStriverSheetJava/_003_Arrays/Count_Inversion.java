package aToZStriverSheetJava._003_Arrays;

import java.util.*;

public class Count_Inversion {
    static int mergeSort(int[] nums, int l, int r){
        int cnt = 0;
        if(l >= r){
            return cnt;
        }
        int mid = l + (r-l)/2;
        cnt += mergeSort(nums, l, mid);
        cnt += mergeSort(nums, mid+1, r);
        cnt += merge(nums, l, mid, r);

        return cnt;
    }

    static int merge(int[] nums, int low, int mid, int high){
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        int cnt = 0; // mod - 1

        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
                cnt += (mid-left+1);
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

        return cnt;
    }

    static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length-1);
    }
}
