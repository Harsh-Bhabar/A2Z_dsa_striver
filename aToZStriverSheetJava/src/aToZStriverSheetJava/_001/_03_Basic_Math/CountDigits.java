package aToZStriverSheetJava._001._03_Basic_Math;

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
