package aToZStriverSheetJava._007_Recursion.All;

import java.util.*;

//link - https://leetcode.com/problems/permutation-sequence/

public class Permutation_sequence {

    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();

        int fact = 1; // calculate n-1 fact to find first block
        for(int i=1; i<n; i++){
            nums.add(i);
            fact = fact * i;
        }
        nums.add(n);

        String ans = "";
        k -= 1; // 0 based indexing

        while(true){
            ans += nums.get(k / fact);
            nums.remove(k / fact);
            if(nums.size() == 0){
                break;
            }
            k = k % fact;
            fact = fact / nums.size(); // siez of the new list
        }

        return ans;
    }
}
