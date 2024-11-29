package aToZStriverSheetJava._007_Recursion.All;

import java.util.ArrayList;
import java.util.List;

//link - https://leetcode.com/problems/n-queens/

public class N_Queens {

    List<List<String>> ans = new ArrayList<>();

    public void solve(int col, char[][] board, int[] leftRow, int[] upperDiag, int[] lowerDiag){
        if(col == board.length){
            ans.add(construct(board));
            return;
        }

        for(int row=0; row<board.length; row++){
            if(leftRow[row] == 0 &&
                    upperDiag[row + col] == 0 &&
                    lowerDiag[board.length - 1 + col - row] == 0){

                board[row][col] = 'Q';
                leftRow[row] = 1;
                upperDiag[row + col] = 1;
                lowerDiag[board.length - 1 + col - row] = 1;

                solve(col+1, board, leftRow, upperDiag, lowerDiag);

                board[row][col] = '.';
                leftRow[row] = 0;
                upperDiag[row + col] = 0;
                lowerDiag[board.length - 1 + col - row] = 0;
            }
        }
    }

    public List<String> construct(char[][] board){
        List<String> ans = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            String str = new String(board[i]);
            ans.add(str);
        }
        return ans;
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        int[] leftRow = new int[n];
        int[] upperDiag = new int[2*n - 1];
        int[] lowerDiag = new int[2*n - 1];

        solve(0, board, leftRow, upperDiag, lowerDiag);

        return ans;
    }
}
