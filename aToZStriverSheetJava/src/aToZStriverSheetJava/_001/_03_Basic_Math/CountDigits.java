package aToZStriverSheetJava._001._03_Basic_Math;

//link - https://leetcode.com/problems/count-the-digits-that-divide-a-number/description/

public class CountDigits {

    public int countDigits(int num) {
        int cnt = 0 ;
        int n = num; // var to be manipulated

        while( n > 0 ){
            int rem = n % 10;
            if (rem != 0 && num % rem == 0){
                cnt += 1;
            }
            n /= 10;
        }

        return cnt;
    }

    public static void main(String[] args){

    }
}
