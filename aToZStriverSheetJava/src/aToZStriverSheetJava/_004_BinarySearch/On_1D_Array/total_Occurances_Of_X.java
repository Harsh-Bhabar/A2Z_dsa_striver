package aToZStriverSheetJava._004_BinarySearch.On_1D_Array;

//link - https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1

public class total_Occurances_Of_X {
    int findFirstOcc(int[] nums, int l, int r, int target){
        int first = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                first = mid;
                r = mid-1;
            }
            else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return first;
    }

    int findLastOcc(int[] nums, int l, int r, int target){
        int last = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid]== target){
                last = mid;
                l = mid+1;
            }
            else if(nums[mid] < target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return last;
    }

    int count(int[] nums, int target) {
        int first = findFirstOcc(nums, 0, nums.length-1, target);
        if(first == -1){
            return 0;
        }
        int last = findLastOcc(nums, 0, nums.length-1, target);

        // System.out.println(first + " " + last);

        return last - first + 1;
    }
}
