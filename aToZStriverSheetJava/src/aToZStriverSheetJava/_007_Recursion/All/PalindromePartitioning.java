package aToZStriverSheetJava._007_Recursion.All;

import java.util.ArrayList;
import java.util.List;

//link - https://leetcode.com/problems/palindrome-partitioning/

public class PalindromePartitioning {

    List<List<String>> ans = new ArrayList<>();

    public void helper(int index, String s, List<String> temp){
        if(index == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index; i<s.length(); i++){
            if(isPalindrome(s.substring(index, i+1))){
                temp.add(s.substring(index, i+1));
                helper(i+1, s, temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;

        while(l <= r){
            if(s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }

        return true;
    }

    public List<List<String>> partition(String s) {
        List<String> temp = new ArrayList<>();
        helper(0, s, temp);
        return ans;
    }
}
