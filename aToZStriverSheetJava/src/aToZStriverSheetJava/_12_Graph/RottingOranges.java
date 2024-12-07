package aToZStriverSheetJava._12_Graph;

import java.util.*;

//link - https://leetcode.com/problems/rotting-oranges/

public class RottingOranges {

    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dirs = new int[][]{
                {0, 1},
                {1, 0},
                {-1, 0},
                {0, -1}
        };
        Queue<Pair> q = new LinkedList<>();
        int freshCnt = 0 ;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    freshCnt++;
                }
                else if(grid[i][j] == 2){
                    q.offer(new Pair(i, j));
                }
            }
        }

        if(freshCnt == 0){
            return 0;
        }

        int minutes = 0;

        while(!q.isEmpty()){
            int n = q.size();
            boolean newRotten = false;
            for(int i=0; i<n; i++){
                Pair curr = q.poll();
                for(int[] dir: dirs){
                    int dx = dir[0] + curr.row;
                    int dy = dir[1] + curr.col;

                    if(dx >= 0 && dx < rows && dy >= 0 && dy < cols && grid[dx][dy] == 1){
                        newRotten = true;
                        grid[dx][dy] = 2;
                        q.offer(new Pair(dx, dy));
                        freshCnt--;
                    }
                }
            }
            if(newRotten){
                minutes++;
            }
        }

        return freshCnt == 0 ? minutes : -1;
    }
}
