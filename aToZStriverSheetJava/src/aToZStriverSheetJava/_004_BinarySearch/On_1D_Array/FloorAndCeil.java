package aToZStriverSheetJava._004_BinarySearch.On_1D_Array;

import java.util.Arrays;

//link - https://www.geeksforgeeks.org/problems/ceil-the-floor2802/0

public class FloorAndCeil {

    public int findFloor(int[] nums, int l, int r, int x){
        int floor = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] <= x){
                floor = nums[mid];
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return floor;
    }

    public int findCeil(int[] nums, int l, int r, int x){
        int ceil = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] < x){
                l = mid+1;
            }
            else{
                ceil = nums[mid];
                r = mid-1;
            }
        }
        return ceil;
    }

    public int[] getFloorAndCeil(int x, int[]  nums) {
        Arrays.sort(nums);

        int floor = findFloor(nums, 0, nums.length-1, x);
        int ceil = findCeil(nums, 0, nums.length-1, x);

        return new int[]{floor, ceil};
    }
}
