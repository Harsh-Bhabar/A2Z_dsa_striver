package aToZStriverSheetJava._007_Recursion;

import java.util.*;

//link - https://leetcode.com/problems/combination-sum/description/

public class Combination_Sum {
    List<List<Integer>> ans = new ArrayList<>();

    public void helper(int i, int[] nums, List<Integer> temp, int target){
        if(i == nums.length || target < 0){
            return;
        }
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        helper(i, nums, temp, target-nums[i]);
        temp.remove(temp.size()-1);
        helper(i+1, nums, temp, target);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        helper(0, candidates, temp, target);
        return ans;
    }
}
