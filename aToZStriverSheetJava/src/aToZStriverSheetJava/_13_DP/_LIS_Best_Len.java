package aToZStriverSheetJava._13_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _LIS_Best_Len {
//    -------- n^2  + n

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 0;

        for(int i=0; i<n; i++){
            for(int prev=0; prev<i; prev++){
                if(nums[prev] < nums[i]){
                    dp[i] = Math.max(dp[i], 1+dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        return maxi;
    }


//    ------ Binary Search


    public int lengthOfLIS_BS(int[] nums) {
        ArrayList<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            // Find the position where `num` can be inserted
            int pos = Collections.binarySearch(lis, num);

            // If the number is not found, binarySearch returns (-(insertion point) - 1)
            if (pos < 0) {
                pos = -(pos + 1);
            }

            // If pos == size of lis, append num, otherwise replace the element at pos
            if (pos == lis.size()) {
                lis.add(num);
            } else {
                lis.set(pos, num);
            }
        }

        return lis.size();
    }

}
