package aToZStriverSheetJava._003_Arrays.Easy;

import java.util.HashMap;

//link - https://leetcode.com/problems/subarray-sum-equals-k/

public class NumberOfSubarraysWithSumK {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int sum = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(sum == k){
                ans++;
            }

            if(mp.containsKey(sum-k)){
                ans += mp.get(sum-k);
            }

            mp.put(sum, mp.getOrDefault(sum, 0)+1);
        }

        return ans;
    }

}
