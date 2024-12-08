package aToZStriverSheetJava._12_Graph;

//link - https://leetcode.com/problems/number-of-islands/

public class Number_of_Island {
    public void DFS(char[][] grid, int i, int j){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1'){
            grid[i][j] = '2';
            DFS(grid, i+1, j);
            DFS(grid, i, j+1);
            DFS(grid, i-1, j);
            DFS(grid, i, j-1);
        }else{
            return;
        }
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int ans = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == '1'){
                    DFS(grid, i, j);
                    ans += 1;
                }
            }
        }

        return ans;
    }
}
