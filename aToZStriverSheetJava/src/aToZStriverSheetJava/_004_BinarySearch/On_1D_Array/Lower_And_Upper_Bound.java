package aToZStriverSheetJava._004_BinarySearch.On_1D_Array;

//link -https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class Lower_And_Upper_Bound {

    public int findFirstOcc(int[] nums, int l, int r, int target){
        int firstOcc = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                firstOcc = mid;
                r = mid-1;
            }
            else if(nums[mid] < target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return firstOcc;
    }

    public int findLastOcc(int[] nums, int l, int r, int target){
        int lastOcc = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                lastOcc = mid;
                l = mid+1;
            }
            else if(nums[mid] < target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return lastOcc;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int l = 0;
        int r = nums.length-1;

        int first = findFirstOcc(nums, 0, r, target);
        if(first != -1){
            ans[0] = first;
            ans[1] = findLastOcc(nums, 0, r, target);
            return ans;
        }
        else{
            return new int[]{-1, -1};
        }
    }
}
