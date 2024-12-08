package aToZStriverSheetJava._12_Graph;

import java.util.*;

public class Number_of_Island_BFS {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    class Solution {

        int[][] dirs = new int[][]{
                {0, 1},
                {1, 0},
                {-1, 0},
                {0, -1}
        };

        public void BFS(char[][] grid, int i, int j){
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(i, j));

            while(!q.isEmpty()){
                Pair curr = q.poll();
                for(int[] dir : dirs){
                    int dx = dir[0] + curr.row;
                    int dy = dir[1] + curr.col;

                    if(dx >= 0 && dy >= 0 && dx < grid.length && dy < grid[0].length && grid[dx][dy] == '1'){
                        grid[dx][dy] = '2';
                        q.offer(new Pair(dx, dy));
                    }
                }
            }
        }

        public int numIslands(char[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;

            int ans = 0;
            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    if(grid[i][j] == '1'){
                        BFS(grid, i, j);
                        ans += 1;
                    }
                }
            }

            return ans;
        }
    }
}
