package aToZStriverSheetJava._007_Recursion.Basics;

public class Fibonacci {
    // find nth fibonacci

    public static int helper(int n){
        if(n <= 1){
            return n;
        }

        return helper(n-1) + helper(n-2);
    }

    public static void main(String[] args){
        System.out.println(helper(10));
    }
}
