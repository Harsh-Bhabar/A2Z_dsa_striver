package aToZStriverSheetJava._009_StackAndQueue;

import java.util.Stack;

public class Design_MinStack_NoExtraspace {
    class MinStack {

        Stack<Long> st = new Stack<>();
        long minEle = Integer.MIN_VALUE;

        public MinStack() {

        }

        public void push(int val) {
            if(st.isEmpty()){
                st.push((long) val);
                minEle = val;
            }
            else if(val < minEle){
                st.push((long) (2L * val)-minEle); // craeting a flag value
                minEle = val;
            }else{
                st.push((long) val);
            }
        }

        public void pop() {
            long top = st.peek();
            if(top >= minEle){
                st.pop();
            }else{ // a flag value, have to update the min
                minEle = (2L * minEle - top);
                st.pop();
            }
        }

        public int top() {
            long top = st.peek();
            if(top < minEle){
                return (int) minEle;
            }else{
                return (int) top;
            }
        }

        public int getMin() {
            return (int) minEle;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

}
