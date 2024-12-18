package aToZStriverSheetJava._004_BinarySearch.On_Answer;

//link - https://leetcode.com/problems/kth-missing-positive-number/

public class Kth_Missing_Number {
//    O(n)
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        for(int i=0; i<n; i++){
            if(arr[i] <= k){
                k++;
            }else{
                break;
            }
        }
        return k;
    }
//    O(log N)
    public int findKthPositive_2(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = n-1;

        while(l <= r){
            int mid = l + (r-l)/2;
            int missingAtMid = nums[mid] - (mid+1); // currNum - expectedNum
            if(missingAtMid < k){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        // System.out.println("l - r " + l + " " + r);
        return l + k;
    }
}
