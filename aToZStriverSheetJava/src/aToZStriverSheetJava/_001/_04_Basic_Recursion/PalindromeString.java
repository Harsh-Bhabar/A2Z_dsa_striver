package aToZStriverSheetJava._001._04_Basic_Recursion;

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
        String str = "harshsrah";
        System.out.println("is it - ? " + isPalindrome(str, 0, str.length()-1));
    }
}
