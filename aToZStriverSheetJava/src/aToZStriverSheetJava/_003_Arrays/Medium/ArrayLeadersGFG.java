package aToZStriverSheetJava._003_Arrays.Medium;

import java.util.ArrayList;
import java.util.Collections;

//link - https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=leaders-in-an-array

public class ArrayLeadersGFG {
    static ArrayList<Integer> leaders(int nums[]) {
        int n = nums.length;
        int currMax = Integer.MIN_VALUE;

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=n-1; i>=0; i--){
            if(nums[i] >= currMax){
                currMax = nums[i];
                ans.add(currMax);
            }
        }

        Collections.reverse(ans);

        return ans;
    }
}
