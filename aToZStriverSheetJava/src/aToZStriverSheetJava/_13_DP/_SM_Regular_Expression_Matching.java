package aToZStriverSheetJava._13_DP;

//link - https://leetcode.com/problems/regular-expression-matching/

public class _SM_Regular_Expression_Matching {
    Boolean[][] dp;

    public boolean solve(int i, String s, int j, String p){
        if(i < 0 && j < 0){
            return true;
        }
        if(j < 0){
            return false;
        }
        if(i < 0){
            if(j > 0 && p.charAt(j) == '*'){
                return solve(i, s, j-2, p);
            }
            return false;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }

        if(p.charAt(j) == '*'){
            if(j > 0 && (p.charAt(j-1) == '.' || s.charAt(i) == p.charAt(j-1))){
                return dp[i][j] = solve(i-1, s, j, p) || solve(i, s, j-2, p);
            }
            return dp[i][j] = solve(i, s, j-2, p);
        }

        if(p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)){
            return dp[i][j] = solve(i-1, s, j-1, p);
        }

        return dp[i][j] = false;
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        dp = new Boolean[m][n];

        return solve(m-1, s, n-1, p);
    }
}
