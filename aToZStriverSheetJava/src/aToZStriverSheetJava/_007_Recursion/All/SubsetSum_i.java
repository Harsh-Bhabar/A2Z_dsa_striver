package aToZStriverSheetJava._007_Recursion.All;

import java.util.ArrayList;

//link - https://www.geeksforgeeks.org/problems/subset-sums2234/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=subset-sums

public class SubsetSum_i {
    ArrayList<Integer> ans = new ArrayList<>();

    public void helper(int i, int[] nums, int sum){
        if(i == nums.length){
            ans.add(sum);
            return;
        }
        helper(i+1, nums, sum + nums[i]);
        helper(i+1, nums, sum);
    }

    public ArrayList<Integer> subsetSums(int[] arr) {
        helper(0, arr, 0);
        return ans;
    }
}
