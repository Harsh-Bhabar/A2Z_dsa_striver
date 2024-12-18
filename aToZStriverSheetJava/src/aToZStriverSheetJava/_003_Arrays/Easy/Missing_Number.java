package aToZStriverSheetJava._003_Arrays.Easy;

//link - https://leetcode.com/problems/missing-number/

public class Missing_Number {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int x: nums){
            sum += x;
        }
        int sumOfN = n * (n+1)/2;
        return sumOfN- sum;
    }
}
