package aToZStriverSheetJava._003_Arrays;

//link - https://leetcode.com/problems/majority-element/

public class Majority_Element {
    public int majorityElement(int[] nums) {
        int ele = 0;
        int cnt = 0;

        for(int i=0; i<nums.length; i++){
            if(cnt == 0){
                ele = nums[i];
            }
            cnt += (ele == nums[i]) ? 1 : -1;
        }

        return ele;
    }
}
