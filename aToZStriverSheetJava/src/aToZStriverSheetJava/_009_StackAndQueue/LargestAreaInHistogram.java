package aToZStriverSheetJava._009_StackAndQueue;

import java.util.*;

//link - https://leetcode.com/problems/largest-rectangle-in-histogram/

public class LargestAreaInHistogram {

    public List<Integer> findNearestSmallerToLeft(int[] nums){
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans.add(-1);
            }else{
                ans.add(st.peek());
            }
            st.push(i);
        }
        return ans;
    }

    public List<Integer> findNearestSmallerToRight(int[] nums){
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans.add(nums.length); // since no building there
            }else{
                ans.add(st.peek());
            }
            st.push(i);
        }
        Collections.reverse(ans);
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        List<Integer> nsl = findNearestSmallerToLeft(heights);
        List<Integer> nsr = findNearestSmallerToRight(heights);

        int ans = 0;
        for(int i=0; i<heights.length; i++){
            int width = nsr.get(i)-nsl.get(i)-1;
            ans = Math.max(ans, width*heights[i]);
        }

        return ans;
    }
}
