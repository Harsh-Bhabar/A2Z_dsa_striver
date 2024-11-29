package aToZStriverSheetJava._007_Recursion.All;

import java.util.ArrayList;
import java.util.Arrays;

//link - https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

public class RatInAMaze {

    ArrayList<String> ans = new ArrayList<>();
    int[] di = {1, 0, 0, -1};
    int[] dj = {0, -1, 1, 0};

    public void solve(int i, int j, int n, ArrayList<ArrayList<Integer>> mat, int[][] vis, String temp){
        if(i == n-1 && j == n-1){
            ans.add(temp);
            return;
        }

        String dir = "DLRU";
        for(int ind=0; ind<4; ind++){
            int nexti = i + di[ind];
            int nextj = j + dj[ind];

            if(nexti >= 0 && nexti < n && nextj >= 0 && nextj < n &&
                    vis[nexti][nextj] == 0 && mat.get(nexti).get(nextj) == 1){
                vis[nexti][nextj] = 1;
                solve(nexti, nextj, n, mat, vis, temp + dir.charAt(ind));
                vis[nexti][nextj] = 0;
            }
        }
    }

    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        int n = mat.size();

        if(mat.get(0).get(0) == 0 || mat.get(n-1).get(n-1) == 0){
            return ans;
        }

        int[][] vis = new int[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(vis[i], 0);
        }

        vis[0][0] = 1;
        solve(0, 0, n, mat, vis, "");

        return ans;
    }
}
