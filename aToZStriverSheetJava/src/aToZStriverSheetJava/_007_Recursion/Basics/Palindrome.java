package aToZStriverSheetJava._007_Recursion.Basics;

public class Palindrome {
    public static boolean palindrom(String s, int l, int r){
        if(l == r){
            return true;
        }
        if(s.charAt(l) != s.charAt(r)){
            return false;
        }
        return palindrom(s, l+1, r-1);
    }
    public static void main(String[] args){
        String s = "ababa";
        System.out.println(palindrom(s, 0, s.length()-1));
        return;
    }
}
