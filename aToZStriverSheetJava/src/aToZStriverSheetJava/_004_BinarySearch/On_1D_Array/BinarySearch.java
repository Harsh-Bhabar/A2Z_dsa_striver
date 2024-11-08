package aToZStriverSheetJava._004_BinarySearch.On_1D_Array;

public class BinarySearch {
    // Iterative
    public int search_1(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;

        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }

        return -1;
    }
    // Recursive
    public int BinarySearch(int[] nums, int l, int r, int target){
        if(l > r){
            return -1;
        }
        int mid = l+(r-l)/2;
        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid] < target){
            return BinarySearch(nums, mid+1, r, target);
        }
        return BinarySearch(nums, l, mid-1, target);
    }

    public int search(int[] nums, int target) {
        return BinarySearch(nums, 0, nums.length-1, target);
    }
}
