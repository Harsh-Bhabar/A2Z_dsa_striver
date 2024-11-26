package aToZStriverSheetJava._007_Recursion.Basics;

//link - https://leetcode.com/problems/missing-number/

public class SumOfN {
    public int findSumOfN(int n){
        if(n == 0){
            return 0;
        }else{
            return n + findSumOfN(n-1);
        }
    }

    public int missingNumber(int[] nums) {
        int actualSum = 0;
        for(int num : nums){
            actualSum += num;
        }
        int expectedSum = findSumOfN(nums.length);
        return expectedSum - actualSum;
    }
}
