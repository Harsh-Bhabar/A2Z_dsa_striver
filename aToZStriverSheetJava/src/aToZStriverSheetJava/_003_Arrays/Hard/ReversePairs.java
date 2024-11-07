package aToZStriverSheetJava._003_Arrays.Hard;

import java.util.*;

//link - https://leetcode.com/problems/reverse-pairs/description/

public class ReversePairs {

    public int countPairs(int[] nums, int low, int mid, int high){
        int cnt = 0;
        int right = mid+1;
        for(int i=low; i<=mid; i++){
            while(right <= high && (long) nums[i] > (long) 2 * nums[right]){
                right++;
            }
            cnt += (right - (mid +1));
        }
        return cnt;
    }

    public void merge(int[] nums, int low, int mid, int high){
        int left = low;
        int right = mid+1;
        List<Integer> temp = new ArrayList<>();

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
    }

    public int mergeSort(int[] nums, int l, int r){
        int cnt = 0;
        if(l >= r){
            return cnt ;
        }
        int mid = l + (r-l)/2;
        cnt += mergeSort(nums, l, mid);
        cnt += mergeSort(nums, mid+1, r);
        cnt += countPairs(nums, l, mid, r);
        merge(nums, l, mid, r);
        return cnt;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
}
