package aToZStriverSheetJava._007_Recursion.Subsequence;

import java.util.*;

//link - https://leetcode.com/problems/permutations/

public class Permutations {

    List<List<Integer>> ans = new ArrayList<>();

    public void helper(int[] nums, List<Integer> temp, boolean[] taken){
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!taken[i]){
                taken[i] = true;
                temp.add(nums[i]);
                helper(nums, temp, taken);
                temp.remove(temp.size()-1);
                taken[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] taken = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        helper(nums, temp, taken);
        return ans;
    }
}
