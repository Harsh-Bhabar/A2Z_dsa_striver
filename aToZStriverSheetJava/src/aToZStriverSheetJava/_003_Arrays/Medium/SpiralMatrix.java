package aToZStriverSheetJava._003_Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

//link - https://leetcode.com/problems/spiral-matrix/

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;
        int m = mat.length;
        int n = mat[0].length;

        while(i >=0 && i < m && j >=0 && j < n && mat[i][j] != Integer.MAX_VALUE){
            // go right
            while(j < n && mat[i][j] != Integer.MAX_VALUE){
                ans.add(mat[i][j]);
                mat[i][j] = Integer.MAX_VALUE;
                j++;
            }
            i++;
            j--;

            // go down
            while(i < m && mat[i][j] != Integer.MAX_VALUE){
                ans.add(mat[i][j]);
                mat[i][j] = Integer.MAX_VALUE;
                i++;
            }
            i--;
            j--;

            // go left
            while(j >= 0 && mat[i][j] != Integer.MAX_VALUE){
                ans.add(mat[i][j]);
                mat[i][j] = Integer.MAX_VALUE;
                j--;
            }
            j++;
            i--;

            // go up
            while(i >= 0 && mat[i][j] != Integer.MAX_VALUE){
                ans.add(mat[i][j]);
                mat[i][j] = Integer.MAX_VALUE;
                i--;
            }
            i++;
            j++;
        }

        return ans;
    }
}
