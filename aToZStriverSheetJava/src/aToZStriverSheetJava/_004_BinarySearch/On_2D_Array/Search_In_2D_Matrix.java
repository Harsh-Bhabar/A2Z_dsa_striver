package aToZStriverSheetJava._004_BinarySearch.On_2D_Array;

//link - https://leetcode.com/problems/search-a-2d-matrix/

public class Search_In_2D_Matrix {
    // way 1 - O(m) + O(log n)
    public boolean binarySearch(int[] nums, int x){
        int n = nums.length;
        int l = 0;
        int r = n-1;
        while( l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == x){
                return true;
            }
            else if(nums[mid] < x){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m; i++){
            if(matrix[i][0] <= target && target <= matrix[i][n-1]){
                return binarySearch(matrix[i], target);
            }
        }

        return false;
    }

    // way 2 - O(log m*n)
    public boolean searchMatrix_2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0;
        int r = m * n - 1;

        while(l <= r){
            int mid = l + (r-l)/2;
            // flattened indexes
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target){
                return true;
            }
            else if(matrix[row][col] < target){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }

        return false;
    }

}
