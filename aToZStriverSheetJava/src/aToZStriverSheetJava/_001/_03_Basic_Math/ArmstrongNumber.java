package aToZStriverSheetJava._001._03_Basic_Math;

//desc - https://takeuforward.org/maths/check-if-a-number-is-armstrong-number-or-not/

public class ArmstrongNumber {

    static String armstrongNumber(int n) {
        int ogNum = n;
        int sum = 0;
        int numLen = String.valueOf(n).length();

        while(n != 0){
            int digit = n % 10;
            sum += Math.pow(digit, numLen);
            n /= 10;
        }

        if(sum == ogNum){
            return "true";
        }else{
            return "false";
        }
    }

}
