package aToZStriverSheetJava._009_StackAndQueue;

import java.util.*;

//link - https://leetcode.com/problems/maximal-rectangle/

public class LargestRectangleIn2DMatrix {

    public List<Integer> findNSR(int[] nums){
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i=nums.length-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans.add(st.peek());
            }else{
                ans.add(nums.length);
            }
            st.push(i);
        }
        Collections.reverse(ans);
        return ans;
    }

    public List<Integer> findNSL(int[] nums){
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                ans.add(st.peek());
            }else{
                ans.add(-1);
            }
            st.push(i);
        }
        return ans;
    }

    public int maximumAreaHistogram(int[] nums){
        List<Integer> nsr = findNSR(nums);
        List<Integer> nsl = findNSL(nums);

        int area = 0;
        for(int i=0; i<nums.length; i++){
            area = Math.max(area, (nsr.get(i)-nsl.get(i)-1) * nums[i]);
        }

        return area;
    }

    public int maximalRectangle(char[][] matrix) {

        int ans = 0;

        int[] heights = new int[matrix[0].length];
        Arrays.fill(heights, 0);
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == '0'){
                    heights[j] = 0;
                }else{
                    heights[j] += 1;
                }
            }
            ans = Math.max(ans, maximumAreaHistogram(heights));
        }

        return ans;
    }
}
