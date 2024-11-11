package aToZStriverSheetJava._004_BinarySearch.On_2D_Array;

public class RowsWithMaximumOnes {

    public int getCount(int[] nums){
        int cnt = 0;
        int n = nums.length;
        if(nums[n-1] == 0){
            return 0;
        }
        int l = 0;
        int r = n-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == 0){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return n - l;
    }

    public int[] rowAndMaximumOnes(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int ansCnt = 0;
        int ansIndex = -1;

        for(int i=0; i<rows; i++){
            int cnt = getCount(mat[i]);
            if(ansCnt < cnt){
                ansCnt = cnt;
                ansIndex = i;
            }
        }

        return new int[]{ansIndex, ansCnt};
    }
}
