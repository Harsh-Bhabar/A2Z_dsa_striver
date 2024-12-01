package aToZStriverSheetJava._009_StackAndQueue;

import java.util.*;

//link - https://leetcode.com/problems/online-stock-span/

public class StockSpanProblem {

    // for array
    public ArrayList<Integer> calculateSpan(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans.add(i+1);
            }else{
                ans.add(i-st.peek());
            }
            st.push(i);
        }

        return ans;
    }

    // implementation

    class StockSpanner {

        Stack<int[]> st = new Stack<>();

        public StockSpanner() {

        }

        public int next(int price) {
            int cnt = 1;
            while(!st.isEmpty() && st.peek()[0] <= price){
                cnt += st.peek()[1];
                st.pop();
            }
            st.push(new int[]{price, cnt});
            return cnt;
        }
    }
}
