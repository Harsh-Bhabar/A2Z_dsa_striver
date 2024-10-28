package aToZStriverSheetJava._003_Arrays.Medium;

import java.util.Arrays;

public class NextPermutation {

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // 1. find breaking point
        int ind = -1;

        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                ind = i;
                break;
            }
        }

        // if no such ind exist, means there's no break point
        if(ind == -1){
            Arrays.sort(nums);
            return;
        }

        // 2. next greater from last
        for(int i=n-1; i>ind; i--){
            if(nums[i] > nums[ind]){
                swap(nums, ind, i);
                break;
            }
        }

        // 3. sort everything after ind
        Arrays.sort(nums, ind+1, n);
    }
}
