package aToZStriverSheetJava._001_Basics._04_Basic_Recursion;

// link - https://leetcode.com/problems/valid-palindrome/description/

public class PalindromeString {

    public static boolean isPalindrome(String s, int start, int end){
        if(start >= end){
            return true;
        }
        if(s.charAt(start) == s.charAt(end)){
            return isPalindrome(s, start + 1, end - 1);
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        String str = "A man, a plan, a canal: Panama"; // amanaplanacanalpanama

        StringBuilder sb = new StringBuilder();

        for(char c: str.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }

        String newStr = sb.toString();
        System.out.println("is it - ? " + isPalindrome(newStr, 0, newStr.length()-1));
    }
}
