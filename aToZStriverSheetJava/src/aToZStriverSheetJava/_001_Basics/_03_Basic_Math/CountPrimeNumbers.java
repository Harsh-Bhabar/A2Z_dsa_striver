package aToZStriverSheetJava._001_Basics._03_Basic_Math;

import java.util.Arrays;

//link - https://leetcode.com/problems/count-primes/

public class CountPrimeNumbers {

    public int countPrimes(int n) {
        // algo - Sieve of Erathostenes
        if( n < 2 ){
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for(int i=2; i*i < n; i += 1){
            if(isPrime[i]){
                for(int j = i*i ; j < n ; j += i){
                    isPrime[j] = false;
                }
            }
        }

        int cnt = 0;
        for(int i=2; i<n; i++){
            if(isPrime[i]){
                cnt++;
            }
        }

        return cnt;
    }
}