package aToZStriverSheetJava._12_Graph;

import java.util.*;

//link - https://www.geeksforgeeks.org/problems/number-of-distinct-islands/0

public class Number_of_DISTINCT_island {
    HashSet<List<String>> hset ;

    public void DFS(int[][] grid, int i, int j, int row0, int col0, List<String> temp){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 2;
            StringBuilder sb = new StringBuilder();
            int dx = i-row0;
            int dy = j-col0;
            sb.append(dx + "_R_" + dy + "_C");
            temp.add(sb.toString());

            DFS(grid, i+1, j, row0, col0, temp);
            DFS(grid, i, j+1, row0, col0, temp);
            DFS(grid, i-1, j, row0, col0, temp);
            DFS(grid, i, j-1, row0, col0, temp);
        }else{
            return;
        }
    }

    int countDistinctIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        hset = new HashSet<>();

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    List<String> temp = new ArrayList<>();
                    DFS(grid, i, j, i, j, temp);
                    hset.add(temp);
                }
            }
        }

        return hset.size();
    }
}
