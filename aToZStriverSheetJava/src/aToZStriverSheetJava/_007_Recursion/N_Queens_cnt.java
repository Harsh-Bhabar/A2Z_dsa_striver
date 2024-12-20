package aToZStriverSheetJava._007_Recursion;

//link - https://leetcode.com/problems/n-queens-ii/?envType=problem-list-v2&envId=backtracking

public class N_Queens_cnt {

    int ans = 0;

    public void solve(int col, int n, int[] leftRow, int[] upperDiag, int[] lowerDiag){
        if(col == n){
            ans++;
            return;
        }

        for(int row=0; row<n; row++){
            if(leftRow[row] == 0 &&
                    upperDiag[row+col] == 0 &&
                    lowerDiag[n-1+col-row] == 0){
                leftRow[row] = 1;
                upperDiag[row+col] = 1;
                lowerDiag[n-1+col-row] = 1;

                solve(col+1, n, leftRow, upperDiag, lowerDiag);

                leftRow[row] = 0;
                upperDiag[row+col] = 0;
                lowerDiag[n-1+col-row] = 0;
            }
        }
    }

    public int totalNQueens(int n) {
        int[] leftRow = new int[n];
        int[] upperDiag = new int[2*n - 1];
        int[] lowerDiag = new int[2*n - 1];

        solve(0, n, leftRow, upperDiag, lowerDiag);

        return ans;
    }
}
