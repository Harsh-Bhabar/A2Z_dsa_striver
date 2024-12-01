package aToZStriverSheetJava._009_StackAndQueue;

import java.util.Stack;

//link - https://leetcode.com/problems/min-stack/

public class Design_MinStack_extraspace {
    // extra space
    class MinStack {

        Stack<Integer> st = new Stack<>();
        Stack<Integer> minSt = new Stack<>();

        public MinStack() {

        }

        public void push(int val) {
            st.push(val);
            if(minSt.isEmpty() || val <= minSt.peek()){
                minSt.push(val);
            }
        }

        public void pop() {
            if(st.peek().equals(minSt.peek())){
                minSt.pop();
            }
            st.pop();
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return minSt.peek();
        }
    }
}
