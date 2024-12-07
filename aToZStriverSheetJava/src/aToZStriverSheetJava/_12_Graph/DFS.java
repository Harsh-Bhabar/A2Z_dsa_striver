package aToZStriverSheetJava._12_Graph;

import java.util.ArrayList;

//link - https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

public class DFS {
    ArrayList<Integer> ans;
    boolean[] visited;

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        ans.add(node);

        for(Integer neighbor: adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, adj);
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ans = new ArrayList<>();
        visited = new boolean[adj.size()];

        dfs(0, adj);

        return ans;
    }
}
