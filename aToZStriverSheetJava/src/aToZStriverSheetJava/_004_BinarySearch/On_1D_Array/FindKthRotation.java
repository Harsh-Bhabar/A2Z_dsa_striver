package aToZStriverSheetJava._004_BinarySearch.On_1D_Array;

import java.util.List;

public class FindKthRotation {
    public int findMini(List<Integer> nums, int l, int r){
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while(l <= r){
            int mid = l + (r-l)/2;
            int tempAns = ans;

            if(nums.get(l) <= nums.get(mid)){
                ans = Math.min(ans, nums.get(l));
                if(tempAns != ans){
                    index = l;
                }
                l = mid+1;
            }
            else{
                ans = Math.min(ans, nums.get(mid));
                if(tempAns != ans){
                    index = mid;
                }
                r = mid-1;
            }
        }
        // System.out.println("MIN " + ans);
        return index;
    }

    public int findKRotation(List<Integer> nums) {
        int n = nums.size();

        if(nums.get(0) < nums.get(n-1)){
            return 0;
        }

        return findMini(nums, 0, n-1);
    }
}
