package aToZStriverSheetJava._003_Arrays.Hard;

import java.util.HashMap;

public class LongestSubarrayWithSumZero {
    int maxLen(int nums[], int n)
    {
        int maxLen = 0;
        int sum = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            sum += nums[i];

            if(sum == 0 && maxLen == 0){
                maxLen = 1;
            }
            if(sum == 0){
                maxLen = i+1;
            }

            if(mp.containsKey(sum)){
                maxLen = Math.max(maxLen, i-mp.get(sum));
            }else{
                mp.put(sum, i);
            }
        }

        return maxLen;
    }
}
