package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

//link - https://leetcode.com/problems/longest-string-chain/

public class _LIS_Longest_String_Chain {


    public boolean compare(String a, String b){
        int m = a.length();
        int n = b.length();
        if(Math.abs(m-n) != 1){
            return false;
        }

        int i = 0;
        int j = 0;
        boolean diffFound = false;

        while(i < m && j < n){
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }
            else{
                if(diffFound){
                    return false;
                }
                diffFound = true;
                if(m > n){
                    i++;
                }else{
                    j++;
                }
            }
        }

        return true;
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b)->Integer.compare(a.length(), b.length()));

        int[] lisLen = new int[n];
        Arrays.fill(lisLen, 1);

        int maxi = 0;

        for(int i=0; i<n; i++){
            for(int prev=0; prev<i; prev++){
                if(compare(words[i], words[prev]) && 1+lisLen[prev] > lisLen[i]){
                    lisLen[i] = 1 + lisLen[prev];
                }
            }
            if(lisLen[i] > maxi){
                maxi = lisLen[i];
            }
        }

        return maxi;
    }

}
