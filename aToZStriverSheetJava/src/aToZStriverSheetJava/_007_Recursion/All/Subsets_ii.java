package aToZStriverSheetJava._007_Recursion.All;

import java.util.*;

//link - https://leetcode.com/problems/subsets-ii/

public class Subsets_ii {
    List<List<Integer>> ans = new ArrayList<>();

    public void helper(int index, int[] nums, List<Integer> temp){
        ans.add(new ArrayList<>(temp));

        for(int i=index; i<nums.length; i++){
            if(i > index && nums[i] == nums[i-1]){
                continue;
            }

            temp.add(nums[i]);
            helper(i+1, nums, temp);
            temp.remove(temp.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        helper(0, nums, temp);
        return ans;
    }
}
