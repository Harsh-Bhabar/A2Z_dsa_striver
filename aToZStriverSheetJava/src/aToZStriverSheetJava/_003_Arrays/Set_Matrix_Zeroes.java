package aToZStriverSheetJava._003_Arrays;

//link - https://leetcode.com/problems/set-matrix-zeroes/description/

public class Set_Matrix_Zeroes {
    public void setZeroes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // check for the first cols
        for(int i=0; i<m; i++){
            if(mat[i][0] == 0){
                firstColZero = true;
            }
        }
        // check for the first row
        for(int j=0; j<n; j++){
            if(mat[0][j] == 0){
                firstRowZero = true;
            }
        }
        // keep track of Zeros from inside in 0th row/col
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(mat[i][j] == 0){
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }
        // if we've zeros in 0th row/col, then make ele zero
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(mat[0][j] == 0 || mat[i][0] == 0){
                    mat[i][j] = 0;
                }
            }
        }
        // we have zeros set for all
        // check for the flags now
        if(firstColZero){
            for(int i=0; i<m; i++){
                mat[i][0] = 0;
            }
        }
        if(firstRowZero){
            for(int j=0; j<n; j++){
                mat[0][j] = 0;
            }
        }
    }
}
