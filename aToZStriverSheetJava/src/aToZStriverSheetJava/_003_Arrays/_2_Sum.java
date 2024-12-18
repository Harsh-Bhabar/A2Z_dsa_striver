package aToZStriverSheetJava._003_Arrays;

//link - https://leetcode.com/problems/two-sum/description/

import java.util.HashMap;

public class _2_Sum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(mp.containsKey(target - nums[i])){
                return new int[] {i, mp.get(target-nums[i])};
            }
            mp.put(nums[i], i);
        }

        return new int[] {};

        // a + b = k
        // a = k - b
        // for a, if (k-b) exist then return the indices
    }
}
