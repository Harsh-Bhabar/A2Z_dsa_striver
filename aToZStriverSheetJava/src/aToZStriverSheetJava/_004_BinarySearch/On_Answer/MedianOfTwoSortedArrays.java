package aToZStriverSheetJava._004_BinarySearch.On_Answer;

//link - https://leetcode.com/problems/median-of-two-sorted-arrays/

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2){
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = n1 + n2;
        int leftHalfLen = (n + 1)/ 2;
        int l = 0;
        int r = n1;

        while(l <= r){
            int cut1 = (l+r)/2;
            int cut2 = leftHalfLen - cut1;

            int l1 = (cut1 > 0) ? nums1[cut1-1] : Integer.MIN_VALUE;
            int l2 = (cut2 > 0) ? nums2[cut2-1] : Integer.MIN_VALUE;
            int r1 = (cut1 < n1) ? nums1[cut1] : Integer.MAX_VALUE;
            int r2 = (cut2 < n2) ?  nums2[cut2] : Integer.MAX_VALUE;

            if(l1 <= r2 && l2 <= r1){ // perfect split
                if(n %  2 == 1){ // odd
                    return Math.max(l1, l2);
                }else{
                    return (double) ((double)(Math.max(l1, l2) + Math.min(r1, r2)) / 2.0);
                }
            }

            if(l1 > r2){
                r = cut1 - 1;
            }else{
                l = cut1 + 1;
            }
        }
        return -1;
    }
}
