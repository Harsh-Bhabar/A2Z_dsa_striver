package aToZStriverSheetJava._004_BinarySearch.On_1D_Array;

//link - https://leetcode.com/problems/find-peak-element/

public class PeakElement {

    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return 0;
        }
        if(nums[0] > nums[1]){
            return 0;
        }
        if(nums[n-1] > nums[n-2]){
            return n-1;
        }

        int l = 1;
        int r = n-2;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]){
                return mid;
            }

            else if(nums[mid+1] > nums[mid]){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return -1;
    }
}
