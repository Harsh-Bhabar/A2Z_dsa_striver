package aToZStriverSheetJava._007_Recursion;

import java.util.*;

//link - https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#

public class M_Coloring_graph {

    public boolean isPossibleToPaint(int node, int toPaint, List<List<Integer>> adj, int[] color){
        for(int neighbor: adj.get(node)){
            if(color[neighbor] == toPaint){
                return false;
            }
        }
        return true;
    }

    public boolean solve(int node, int totalNodes, List<List<Integer>> adj, int m, int[] color){
        if(node == totalNodes){
            return true;
        }

        for(int i=0; i<m; i++){
            if(isPossibleToPaint(node, i, adj, color)){
                color[node] = i;
                if(solve(node+1, totalNodes, adj, m, color)){
                    return true;
                }
                color[node] = -1;
            }
        }

        return false;
    }

    boolean graphColoring(int v, List<int[]> edges, int m) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] color = new int[v];
        Arrays.fill(color, -1);

        return solve(0, v, adj, m, color);
    }
}
