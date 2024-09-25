package aToZStriverSheetJava._001_Basics._05_Basic_Hashing;

import java.util.Collections;
import java.util.HashMap;

//link - https://leetcode.com/problems/count-elements-with-maximum-frequency/

public class MaxFrequency {

    public static int findMaxFreq(int[] nums){
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int num: nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        int maxFreq = Collections.max(mp.values());
        int ans = 0 ;

        for(int i: mp.values()){
            if( i == maxFreq ){
                ans += i;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 2, 1}; // here 1 and 2  have max freq 2, so 2+2 = 4
        System.out.println(findMaxFreq(nums));
    }
}
