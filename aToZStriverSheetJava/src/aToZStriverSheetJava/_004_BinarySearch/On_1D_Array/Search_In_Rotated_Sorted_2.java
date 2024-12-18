package aToZStriverSheetJava._004_BinarySearch.On_1D_Array;

//link - https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

public class Search_In_Rotated_Sorted_2 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;

        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[l] == nums[mid] && nums[mid] == nums[r]){
                l = l + 1;
                r = r - 1;
                continue;
            }

            if(nums[l] <= nums[mid]){
                if(nums[l] <= target && target <= nums[mid]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[r]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
        }

        return false;
    }
}
