package aToZStriverSheetJava._007_Recursion;

import java.util.*;

//link - https://leetcode.com/problems/subsets/

public class Subsets_all_subsets {
    List<List<Integer>> ans = new ArrayList<>();

    public void helper(int i, int[] nums, List<Integer> temp){
        if(i >= nums.length){
            ans.add(new ArrayList<>(temp)); // add a copy of temp to ans
            return;
        }

        // take
        temp.add(nums[i]);
        helper(i+1, nums, temp);

        // not take
        temp.remove(temp.size()-1);
        helper(i+1, nums, temp);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        helper(0, nums, temp);
        return ans;
    }
}
