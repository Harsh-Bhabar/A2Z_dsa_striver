package aToZStriverSheetJava._009_StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStack_usingOneQueue {
    class MyStack {

        Queue<Integer> q = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            q.offer(x);
            int n = q.size();
            for(int i=0; i<n-1; i++){
                q.offer(q.peek());
                q.poll();
            }
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }
}
