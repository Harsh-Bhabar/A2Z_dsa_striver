package aToZStriverSheetJava._009_StackAndQueue;

import java.util.*;

//link - https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

public class NearestSmaller_toLeft {

    static List<Integer> leftSmaller(int n, int nums[])
    {
        Stack<Integer> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && st.peek() >= nums[i]){
                st.pop();
            }
            ans.add(st.isEmpty() ? -1 : st.peek());
            st.push(nums[i]);
        }

        return ans;
    }
}
