package aToZStriverSheetJava._003_Arrays.Medium;

//link - https://leetcode.com/problems/rotate-image/

public class RotateImage {
    public void swap(int[][] mat, int i, int j){
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }

    public void reverseRow(int[][] mat, int i){
        int left = 0;
        int right = mat[i].length-1;

        while(left < right){
            int temp = mat[i][left];
            mat[i][left] = mat[i][right];
            mat[i][right] = temp;
            left++;
            right--;
        }
    }

    public void rotate(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<=i-1; j++){
                swap(mat, i, j);
            }
        }

        for(int i=0; i<m; i++){
            reverseRow(mat, i);
        }

    }
}
