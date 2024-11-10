package aToZStriverSheetJava._004_BinarySearch.On_2D_Array;

//link - https://leetcode.com/problems/search-a-2d-matrix-ii/

public class SearchIn2DMatrix_ii {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;

        while(i < m && j < n){
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }

        return false;
    }
}
