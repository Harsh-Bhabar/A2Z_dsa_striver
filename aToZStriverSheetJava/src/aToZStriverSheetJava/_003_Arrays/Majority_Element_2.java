package aToZStriverSheetJava._003_Arrays;

import java.util.*;

public class Majority_Element_2 {
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int cnt1 = 0;
            int cnt2 = 0;
            int ele1 = Integer.MIN_VALUE;
            int ele2 = Integer.MIN_VALUE;
            int n = nums.length;

            for(int i=0; i<n; i++){
                if(cnt1 == 0 && ele2 != nums[i]){
                    cnt1++;
                    ele1 = nums[i];
                }
                else if(cnt2 == 0 && ele1 != nums[i]){
                    cnt2++;
                    ele2 = nums[i];
                }
                else if(nums[i] == ele1){
                    cnt1++;
                }
                else if(nums[i] == ele2){
                    cnt2++;
                }
                else{
                    cnt1--;
                    cnt2--;
                }
            }

            // we've some elements in ele1 and ele2, but not sure they're majority"

            cnt1 = 0;
            cnt2 = 0;

            for(int i=0; i<n; i++){
                if(nums[i] == ele1) cnt1++;
                else if(nums[i] == ele2) cnt2++;
            }

            int minimum = (int) n/3 + 1;
            List<Integer> ans = new ArrayList<>();

            if(cnt1 >= minimum){
                ans.add(ele1);
            }
            if(cnt2 >= minimum){
                ans.add(ele2);
            }

            return ans;
        }
    }
}
