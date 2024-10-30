package aToZStriverSheetJava._003_Arrays.Hard;

import java.util.*;

//link - https://leetcode.com/problems/pascals-triangle/

public class PascalTriangle_1_2 {

    // PRINT - way - 1 - Brute force

    public int findPascalTriValue(int r, int c){
        // there's a formula (r-1) C (c-1) to find value
        int ans = 1;
        for(int i=0; i<c; i++){
            ans = ans * (r-i);
            ans = ans / (i+1);
        }
        return ans;
    }
    public List<List<Integer>> generate_1(int numRows) {
        // Brute force by finding single-values by R and C

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(Arrays.asList(1)));

        for(int r=2; r<=numRows; r++){
            List<Integer> temp = new ArrayList<>();
            for(int c=1; c<=r; c++){
                temp.add(findPascalTriValue(r-1, c-1));
            }
            ans.add(temp);
        }
        return ans;
    }

    // PRINT - way - 2 - Optimal



    // GET ROW
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int row = rowIndex + 1;
        long colValue = 1;

        ans.add((int) colValue);

        for(int i=1; i<row; i++){
            colValue = colValue * (row - i);
            colValue = colValue / i;
            ans.add((int) colValue);
        }

        return ans;
    }

}
