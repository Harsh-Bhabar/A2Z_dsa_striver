package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

public class _LC_SS_Print {

    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1+1][n2+1];
        for(int[] d: dp){
            Arrays.fill(d, 0);
        }

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // PRINT
        int i = n1;
        int j = n2;
        StringBuilder sb = new StringBuilder();

        while(i > 0 && j > 0){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                sb.append(text1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i-1][j] > dp[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }

        sb.reverse();
        System.out.println(sb.toString());

        return dp[n1][n2];
    }
}
