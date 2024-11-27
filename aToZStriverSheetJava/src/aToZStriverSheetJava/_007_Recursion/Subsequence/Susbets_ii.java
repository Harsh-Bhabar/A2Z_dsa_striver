package aToZStriverSheetJava._007_Recursion.Subsequence;

import java.util.*;

//link - https://leetcode.com/problems/subsets-ii/

public class Susbets_ii {
    HashSet<List<Integer>> ans = new HashSet<>();

    public void helper(int i, int[] nums, List<Integer> temp){
        if(i == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        helper(i+1, nums, temp);
        temp.remove(temp.size()-1);
        helper(i+1, nums, temp);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        helper(0, nums, temp);
        return new ArrayList<>(ans);
    }
}
