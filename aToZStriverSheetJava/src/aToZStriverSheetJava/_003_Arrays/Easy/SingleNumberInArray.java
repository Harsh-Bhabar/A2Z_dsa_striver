package aToZStriverSheetJava._003_Arrays.Easy;

//link - https://leetcode.com/problems/single-number/

public class SingleNumberInArray {
    public int singleNumber(int[] nums) {
        int num = nums[0];
        for(int i=1; i<nums.length; i++){
            num ^= nums[i];
        }
        return num;
    }
}
