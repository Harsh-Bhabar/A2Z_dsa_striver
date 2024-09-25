package aToZStriverSheetJava._001_Basics._04_Basic_Recursion;

public class SumOfNNumbers {

    public static int sumOf(int n){
        if(n == 0){
            return 0;
        }
        else{
            return n + sumOf(n-1);
        }
    }

    public static void main(String[] args){
        System.out.println(sumOf(6));
    }
}
