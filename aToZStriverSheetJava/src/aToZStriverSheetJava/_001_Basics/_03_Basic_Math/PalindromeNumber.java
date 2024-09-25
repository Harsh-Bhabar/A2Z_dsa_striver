package aToZStriverSheetJava._001_Basics._03_Basic_Math;

//link - https://leetcode.com/problems/palindrome-number/

public class PalindromeNumber {
    public int reverseOfNumber(int x){
        int ans = 0;

        while(x != 0){
            ans = ans * 10 + x % 10;
            x /= 10;
        }

        return ans;
    }

    public boolean isPalindrome(int x) {
        if( x < 0 ){
            return false;
        }
        int reverse = reverseOfNumber(x);
        return x == reverse;
    }
}
