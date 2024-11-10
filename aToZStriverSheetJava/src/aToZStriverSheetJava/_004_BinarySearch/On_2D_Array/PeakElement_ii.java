package aToZStriverSheetJava._004_BinarySearch.On_2D_Array;

//link - https://leetcode.com/problems/find-a-peak-element-ii/

public class PeakElement_ii {

    public int maxEleOfColumn(int[][] mat, int m, int n, int col){
        int index = -1;
        int temp = Integer.MIN_VALUE;
        for(int i=0; i<m; i++){
            if(mat[i][col] > temp){
                temp = mat[i][col];
                index = i;
            }
        }
        return index;
    }

    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int l = 0;
        int r = n-1;

        while(l <= r){
            int mid = l + (r-l)/2;

            int maxEleInd = maxEleOfColumn(mat, m, n, mid);
            int left = mid > 0 ? mat[maxEleInd][mid-1] : -1;
            int right = mid < n-1 ? mat[maxEleInd][mid+1] : -1;

            // System.out.println(mid + " " + maxEleInd + " " + left + " " + right);

            if(left < mat[maxEleInd][mid] && mat[maxEleInd][mid] > right){
                return new int[]{maxEleInd, mid};
            }
            else if(left > mat[maxEleInd][mid]){
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        return new int[]{-1, -1};
    }
}
