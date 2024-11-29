package aToZStriverSheetJava._007_Recursion.All;

import java.util.*;

//link - https://leetcode.com/problems/valid-sudoku/

public class Sudoku_isValid {

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j];
                    String row = num + "_R_" + i;
                    String col = num + "_C_" + j;
                    String box = num + "_B_" + i/3 + "_" + j/3;

                    if(seen.contains(row) || seen.contains(col) || seen.contains(box)){
                        return false;
                    }

                    seen.add(row);
                    seen.add(col);
                    seen.add(box);
                }
            }
        }

        return true;
    }

}
