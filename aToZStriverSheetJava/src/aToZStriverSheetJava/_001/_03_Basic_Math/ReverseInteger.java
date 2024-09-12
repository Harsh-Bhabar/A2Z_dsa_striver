package aToZStriverSheetJava._001._03_Basic_Math;

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
