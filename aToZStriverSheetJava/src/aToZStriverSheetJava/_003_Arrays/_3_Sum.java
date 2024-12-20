package aToZStriverSheetJava._003_Arrays;

import java.util.*;

//link - https://leetcode.com/problems/3sum/description/

public class _3_Sum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;

            Arrays.sort(nums);

            for(int i=0; i<n; i++){
                if(i != 0 && nums[i] == nums[i-1]){
                    continue; // skip duplicates
                }

                int j=i+1;
                int k=n-1;

                while(j < k){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum > 0){
                        k--;
                    }
                    else if(sum < 0){
                        j++;
                    }
                    else{
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                        // skip duplicates
                        while(j < k && nums[j] == nums[j-1]) j++;
                        while(j < k && nums[k] == nums[k+1]) k--;
                    }
                }
            }

            return ans;
        }
    }
}
