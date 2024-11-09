package aToZStriverSheetJava._004_BinarySearch.On_1D_Array;

//link - https://leetcode.com/problems/search-in-rotated-sorted-array/description/

public class SearchInRotatedSorted {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;

        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[l] <= nums[mid]){ // sorted left side
                if(nums[l] <= target && target <= nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            else{ // sorted right side
                if(nums[mid] <= target && target <= nums[r]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
        }

        return -1;
    }
}
