package aToZStriverSheetJava._12_Graph;

import java.util.*;

//link - https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

public class CycleDetect_Undirected_DFS {

    boolean[] visited ;

    public boolean hasCycle(int node, int parent, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;

        for(int neigh : adj.get(node)){
            if(!visited[neigh]){
                if(hasCycle(neigh, node, adj)){
                    return true;
                }
            }
            else if(neigh != parent){
                return true;
            }
        }

        return false;
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        visited = new boolean[adj.size()];

        for(int i=0; i<adj.size(); i++){
            if(!visited[i] && hasCycle(i, -1, adj)){
                return true;
            }
        }

        return false;
    }
}
