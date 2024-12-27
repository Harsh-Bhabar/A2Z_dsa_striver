package aToZStriverSheetJava._009_StackAndQueue;

import java.util.*;

//link - https://leetcode.com/problems/sliding-window-maximum/

public class Sliding_Window_Maximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        Deque<Integer> dq = new LinkedList<>();

        while(j < n){

            if(dq.isEmpty()){
                dq.offerLast(j);
            }else{
                // maintaining max ele
                // we only care abt the max ele in the window
                while(!dq.isEmpty() && nums[dq.peekLast()] < nums[j]){
                    dq.pollLast();
                }
                dq.offerLast(j);
            }

            // window size reached
            if(j-i+1 == k){
                ans.add(nums[dq.peekFirst()]);
                if(dq.peekFirst() == i){
                    dq.pollFirst();
                }
                i++;
            }

            j++;
        }

        int[] result = new int[n-k+1];
        for(int x=0; x<=n-k; x++){
            result[x] = ans.get(x);
        }

        return result;
    }
}
