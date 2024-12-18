package aToZStriverSheetJava._003_Arrays;

import java.util.HashMap;

//link - https://leetcode.com/problems/longest-consecutive-sequence/description/

public class Longest_Consecutive_Subsequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }

        HashMap<Integer, Boolean> mp = new HashMap<>();
        for(int x: nums){
            mp.put(x, true);
        }

        int ans = 1;

        for(int key: mp.keySet()){
            if(!mp.containsKey(key-1)){ // start of a sequence
                int cnt = 1;
                int currKey = key;

                while(mp.containsKey(currKey + 1)){
                    cnt++;
                    currKey++;
                }

                ans = Math.max(ans, cnt);
            }
        }

        return ans;
    }
}
