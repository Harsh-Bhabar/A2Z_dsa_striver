package aToZStriverSheetJava._003_Arrays;

//link - https://leetcode.com/problems/maximum-product-subarray/description/

public class Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int pref = 1;
        int suff = 1;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(pref == 0){
                pref = 1;
            }
            if(suff == 0){
                suff = 1;
            }
            pref *= nums[i];
            suff *= nums[n-i-1];
            max = Math.max(max, Math.max(pref, suff));
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
