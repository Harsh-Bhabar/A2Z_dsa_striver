package aToZStriverSheetJava._12_Graph;

import java.util.*;

//link - https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

public class CycleDetect_Undirected_BFS {

    class Pair{
        int node;
        int parent;
        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }
    }

    boolean[] visited ;

    public boolean hasCycle(int node, ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(node, -1));
        visited[node] = true;

        while(!q.isEmpty()){
            Pair curr = q.poll();

            for(int neigh: adj.get(curr.node)){
                if(!visited[neigh]){
                    visited[neigh] = true;
                    q.offer(new Pair(neigh, curr.node));
                }else if(neigh != curr.parent){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        visited = new boolean[adj.size()];

        for(int i=0; i<adj.size(); i++){
            if(!visited[i] && hasCycle(i, adj)){
                return true;
            }
        }
        return false;
    }
}
