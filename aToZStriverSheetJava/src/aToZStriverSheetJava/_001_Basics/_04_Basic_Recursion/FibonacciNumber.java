package aToZStriverSheetJava._001_Basics._04_Basic_Recursion;

import java.util.HashMap;

public class FibonacciNumber {

    private static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int calculateFib(int n){
        if(n == 0 || n == 1){
            return n;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int result = calculateFib(n-1) + calculateFib(n-2);
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args){
        System.out.println("Fib - " + calculateFib(25));
    }
}
