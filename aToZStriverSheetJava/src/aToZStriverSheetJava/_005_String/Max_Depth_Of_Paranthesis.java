package aToZStriverSheetJava._005_String;

//link - https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

public class Max_Depth_Of_Paranthesis {
    public int maxDepth(String s) {
        int ans = Integer.MIN_VALUE;
        int depth = 0;
        for(char ch: s.toCharArray()){
            if(ch == '('){
                depth++;
                ans = Math.max(depth, ans);
            }
            else if(ch == ')'){
                depth--;
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}
