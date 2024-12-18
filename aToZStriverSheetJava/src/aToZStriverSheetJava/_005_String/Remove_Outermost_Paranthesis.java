package aToZStriverSheetJava._005_String;

//link - https://leetcode.com/problems/remove-outermost-parentheses/description/

public class Remove_Outermost_Paranthesis {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for(char c : s.toCharArray()){
            if(c == '('){
                if(depth > 0){
                    result.append(c);
                }
                depth++;
            }else{
                depth--;
                if(depth > 0){
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}
