package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

//link - https://leetcode.com/problems/palindrome-partitioning-ii/

public class _MCM_Palindrome_Partitioning {

//    ------ recurson


    int[] dp ;

    public boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int solve(int i, String S){
        if(i == S.length()){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int mini = Integer.MAX_VALUE;

        for(int j=i; j<S.length(); j++){
            if(isPalindrome(i, j, S)){
                int cost = 1 + solve(j+1, S);
                mini = Math.min(cost, mini);
            }
        }

        return dp[i] = mini;
    }

    public int minCut(String s) {
        int n = s.length();
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(0, s) - 1; // -1 because if of partition at End
    }



//    ---- dp


    public int minCut_2(String s) {
        int n = s.length();
        dp = new int[n+1];
        dp[n] = 0;

        for(int i=n-1; i>=0; i--){
            int mini = Integer.MAX_VALUE;
            for(int j=i; j<n; j++){
                if(isPalindrome(i, j, s)){
                    int cost = 1 + dp[j+1];
                    mini = Math.min(cost, mini);
                }
            }
            dp[i] = mini;
        }

        return dp[0] - 1;
    }

}
