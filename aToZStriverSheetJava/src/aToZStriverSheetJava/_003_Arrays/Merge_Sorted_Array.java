package aToZStriverSheetJava._003_Arrays;

//link - https://leetcode.com/problems/merge-sorted-array/

public class Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0){
            return;
        }

        int p1 = m-1;
        int p2 = n-1;
        int pZero = m+n-1;

        while(p1 >= 0 && p2 >= 0){
            if(nums2[p2] >= nums1[p1]){
                nums1[pZero] = nums2[p2];
                p2--;
            }else{
                nums1[pZero] = nums1[p1];
                p1--;
            }
            pZero--;
        }

        while(p2 >= 0){
            nums1[pZero] = nums2[p2];
            p2--;
            pZero--;
        }

    }
}
