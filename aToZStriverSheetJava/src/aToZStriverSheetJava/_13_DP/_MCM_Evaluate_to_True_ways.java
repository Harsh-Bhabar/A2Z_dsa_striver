package aToZStriverSheetJava._13_DP;

import java.util.Arrays;

public class _MCM_Evaluate_to_True_ways {

//    ---- recursion

    final static int MOD = 1_000_000_007;
    static int[][][] dp;

    public static long solve(int i, int j, int isTrue, char[] S) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }

        if (i == j) {
            if (isTrue == 1) {
                return S[i] == 'T' ? 1 : 0;
            } else {
                return S[i] == 'F' ? 1 : 0;
            }
        }

        long ways = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            long LT = solve(i, k - 1, 1, S) % MOD;
            long LF = solve(i, k - 1, 0, S) % MOD;
            long RT = solve(k + 1, j, 1, S) % MOD;
            long RF = solve(k + 1, j, 0, S) % MOD;

            if (S[k] == '&') {
                if (isTrue == 1) {
                    ways = (ways + (LT * RT) % MOD) % MOD;
                } else {
                    ways = (ways + (LT * RF) % MOD + (LF * RT) % MOD + (LF * RF) % MOD) % MOD;
                }
            } else if (S[k] == '|') {
                if (isTrue == 1) {
                    ways = (ways + (LT * RT) % MOD + (LT * RF) % MOD + (LF * RT) % MOD) % MOD;
                } else {
                    ways = (ways + (LF * RF) % MOD) % MOD;
                }
            } else if (S[k] == '^') {
                if (isTrue == 1) {
                    ways = (ways + (LT * RF) % MOD + (LF * RT) % MOD) % MOD;
                } else {
                    ways = (ways + (LT * RT) % MOD + (LF * RF) % MOD) % MOD;
                }
            }
        }

        dp[i][j][isTrue] = (int) (ways % MOD);
        return ways % MOD;
    }

    static int countWays(int n, String s) {
        dp = new int[n][n][2];

        for (int[][] dd : dp) {
            for (int[] d : dd) {
                Arrays.fill(d, -1);
            }
        }

        return (int) solve(0, n - 1, 1, s.toCharArray());
    }

}
