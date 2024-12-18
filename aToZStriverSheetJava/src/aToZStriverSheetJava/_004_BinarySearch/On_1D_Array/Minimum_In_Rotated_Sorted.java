package aToZStriverSheetJava._004_BinarySearch.On_1D_Array;

//link - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class Minimum_In_Rotated_Sorted {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int ans = Integer.MAX_VALUE;

        while(l <= r){
            int mid = l + (r-l)/2;

            // eliminate the sorted half
            if(nums[l] <= nums[mid]){ // left side
                ans = Math.min(ans, nums[l]);
                l = mid + 1;
            }
            else{ // right side
                ans = Math.min(ans, nums[mid]);
                r = mid - 1;
            }
        }

        return ans;
    }
}
