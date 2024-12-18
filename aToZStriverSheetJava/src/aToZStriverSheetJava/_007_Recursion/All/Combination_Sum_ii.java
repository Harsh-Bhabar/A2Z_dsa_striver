package aToZStriverSheetJava._007_Recursion.All;

import java.util.*;

//link - https://leetcode.com/problems/combination-sum-ii/

public class Combination_Sum_ii {
    List<List<Integer>> ans = new ArrayList<>();

    public void helper(int index, int[] nums, List<Integer> temp, int target){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index; i<nums.length; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] > target){
                break;
            }

            temp.add(nums[i]);
            helper(i+1, nums, temp, target-nums[i]);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        helper(0, candidates, temp, target);
        return ans;
    }
}
