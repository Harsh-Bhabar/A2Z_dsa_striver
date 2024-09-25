package aToZStriverSheetJava._001_Basics._03_Basic_Math;

//link - https://leetcode.com/problems/perfect-number/

public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        int divSum = 0;

        for(int i=1; i<num; i++){
            if(num % i == 0){
                divSum += i;
            }
            if(divSum > num){
                return false;
            }
        }

        return divSum == num;
    }

}
