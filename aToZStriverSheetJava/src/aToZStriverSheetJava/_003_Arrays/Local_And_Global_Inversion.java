package aToZStriverSheetJava._003_Arrays;

import java.util.*;

//link - https://leetcode.com/problems/global-and-local-inversions/

public class Local_And_Global_Inversion {

    public int merge(int[] nums, int low, int mid, int high){
        int left = low;
        int right = mid+1;
        int cnt = 0;
        List<Integer> temp = new ArrayList<>();

        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
                right++;
                cnt += (mid-left+1);
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


    public int mergeSort(int[] nums, int l, int r){
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

    public boolean isIdealPermutation(int[] nums) {
        int local = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                local++;
            }
        }
        int global = mergeSort(nums, 0, nums.length-1);
        return local == global;
    }
}
