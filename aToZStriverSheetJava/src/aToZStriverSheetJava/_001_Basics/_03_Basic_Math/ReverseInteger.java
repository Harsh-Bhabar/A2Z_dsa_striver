package aToZStriverSheetJava._001_Basics._03_Basic_Math;

//link - https://leetcode.com/problems/reverse-integer/

public class ReverseInteger {
    public int reverse(int x) {
        int reverse = 0;

        while(x != 0){
            if (reverse < Integer.MIN_VALUE/10 || reverse > Integer.MAX_VALUE / 10){
                return 0;
            }
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return reverse ;
    }
}
