package aToZStriverSheetJava._005_String.Medium;

//link - https://leetcode.com/problems/reverse-words-in-a-string/

public class ReverseWordsInString {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();

        int ind = s.length()-1;
        StringBuilder temp = new StringBuilder();

        while(ind >= 0){
            char ch = s.charAt(ind);
            if(ch != ' '){
                temp.append(ch);
            }else{
                if(temp.length() > 0){
                    if(ans.length() > 0){
                        ans.append(" ");
                    }
                    ans.append(temp.reverse());
                    temp.setLength(0);
                }
            }
            ind--;
        }

        if(temp.length() > 0){
            if(ans.length() > 0){
                ans.append(" ");
            }
            ans.append(temp.reverse());
        }

        return ans.toString();
    }
}
