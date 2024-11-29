package aToZStriverSheetJava._007_Recursion.All;

import java.util.*;

//link - https://leetcode.com/problems/permutations/

public class Permutation_printAll {
 // way - 1
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

//    way 2


//    List<List<Integer>> ans = new ArrayList<>();

    public void helper2(int index, int[] nums){
        if(index == nums.length){
            List<Integer> temp = new ArrayList<>();
            for(int num: nums){
                temp.add(num);
            }
            ans.add(temp);
            return;
        }

        for(int i=index; i<nums.length; i++){
            swap(i, index, nums);
            helper2(index+1, nums);
            swap(i, index, nums);
        }
    }

    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute2(int[] nums) {
        helper2(0, nums);
        return ans;
    }


}
