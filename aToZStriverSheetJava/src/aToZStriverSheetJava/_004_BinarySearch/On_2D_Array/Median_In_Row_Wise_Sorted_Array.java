package aToZStriverSheetJava._004_BinarySearch.On_2D_Array;

//link - https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=median-in-a-row-wise-sorted-matrix

public class Median_In_Row_Wise_Sorted_Array {

    int upperBound(int[]nums, int x){
        int ans = nums.length;
        int l = 0;
        int r = nums.length-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] > x){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        // System.out.println("CNT for X - " + x + " " + ans);
        return ans;
    }

    int findElementsSmallerThanMid(int[][] mat, int x){
        int cnt = 0 ;
        for(int i=0; i<mat.length; i++){
            cnt += upperBound(mat[i], x);
        }
        return cnt;
    }

    int median(int mat[][], int rows, int cols) {
        // rule [ # of elements <= is our median ]

        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;

        for(int i=0; i<rows; i++){
            l = Math.min(l, mat[i][0]);
            r = Math.max(r, mat[i][cols-1]);
        }

        // System.out.println("L R - " + l + " " + r);

        int requiredCnt = (rows * cols)/ 2;

        while(l <= r){
            int mid = l + (r-l)/2;
            int cnt = findElementsSmallerThanMid(mat, mid);
            if(cnt <= requiredCnt){
                l = mid +1;
            }else{
                r = mid-1;
            }
        }

        return l;

    }
}
