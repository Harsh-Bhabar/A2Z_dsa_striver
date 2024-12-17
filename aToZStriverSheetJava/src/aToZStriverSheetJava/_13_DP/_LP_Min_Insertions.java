package aToZStriverSheetJava._13_DP;

//link - https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

public class _LP_Min_Insertions {
    public int minInsertions(String s) {
        int n1 = s.length();
        String t = new StringBuilder(s).reverse().toString();

        int[][] dp = new int[n1+1][n1+1];

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n1; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int lcs = dp[n1][n1];

        return Math.abs(lcs-n1);
    }
}
