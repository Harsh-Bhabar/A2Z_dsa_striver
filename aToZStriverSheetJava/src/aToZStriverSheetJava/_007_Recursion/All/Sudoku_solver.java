package aToZStriverSheetJava._007_Recursion.All;

//link - https://leetcode.com/problems/sudoku-solver/

public class Sudoku_solver {

    public boolean solve(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){

                    for(char num='1'; num<='9'; num++){
                        if(isValid(board, i, j, num)){
                            board[i][j] = num;
                            if(solve(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int i, int j, char num){
        for(int ind=0; ind<9; ind++){
            if(board[i][ind] == num){
                return false;
            }
            if(board[ind][j] == num){
                return false;
            }
            if(board[3 * (i/3) + (ind/3)][3 * (j/3) + (ind%3)] == num){
                return false;
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
