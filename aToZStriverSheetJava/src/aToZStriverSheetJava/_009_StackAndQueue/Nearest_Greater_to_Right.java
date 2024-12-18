package aToZStriverSheetJava._009_StackAndQueue;

import java.util.*;

//link - https://leetcode.com/problems/next-greater-element-i/

public class Nearest_Greater_to_Right {
    public List<Integer> nextGreaterEle(int[] nums){
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && st.peek() < nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans.add(st.peek());
            }else{
                ans.add(-1);
            }

            st.push(nums[i]);
        }

        Collections.reverse(ans);
        return ans;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        List<Integer> ngr = nextGreaterEle(nums2);

        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums2.length; i++){
            mp.put(nums2[i], ngr.get(i));
        }

        int n1 = nums1.length;
        int[] ans = new int[n1];

        for(int i=0; i<n1; i++){
            ans[i] = mp.get(nums1[i]);
        }

        return ans;
    }
}
