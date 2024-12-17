package aToZStriverSheetJava._13_DP;

//link - https://leetcode.com/problems/shortest-common-supersequence/

public class _LP_SCS {

    public String shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        int[][] dp = new int[n1+1][n2+1];

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int lcs = dp[n1][n2];
        int lengthOfSCS = n1 + n2 - lcs;

        int i = n1;
        int j = n2;
        StringBuilder sb = new StringBuilder();

        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i-1][j] > dp[i][j-1]){
                    sb.append(str1.charAt(i-1));
                    i--;
                }else{
                    sb.append(str2.charAt(j-1));
                    j--;
                }
            }
        }

        while(i > 0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j > 0){
            sb.append(str2.charAt(j-1));
            j--;
        }

        sb.reverse();

        return sb.toString();
    }
}
