package aToZStriverSheetJava._009_StackAndQueue;

import java.util.Stack;

//link - https://leetcode.com/problems/next-greater-element-ii/

public class NearestGreater_toRight_circularList {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }
            ans[i % n] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i % n]);
        }

        return ans;
    }
}
