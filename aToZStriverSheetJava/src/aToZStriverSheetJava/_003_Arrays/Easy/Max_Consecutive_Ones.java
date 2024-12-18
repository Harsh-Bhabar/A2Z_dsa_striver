package aToZStriverSheetJava._003_Arrays.Easy;

//link - https://leetcode.com/problems/max-consecutive-ones/description/

public class Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int cnt = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                cnt++;
            }else{
                // last occurance of 1 wont go here
                if(cnt > ans){
                    ans = cnt;
                }
                cnt = 0;
            }
        }
        return cnt > ans ? cnt : ans;
    }
}
