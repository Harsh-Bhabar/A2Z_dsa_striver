package aToZStriverSheetJava._003_Arrays.Medium;

import java.util.HashMap;

public class LongestConsecutiveSubsequence {
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
