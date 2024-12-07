package aToZStriverSheetJava._12_Graph;

import java.util.*;

//link - https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();

        boolean[] visited = new boolean[V];
        visited[0] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while(!q.isEmpty()){
            Integer curr = q.poll();
            ans.add(curr);

            for(Integer neighbor: adj.get(curr)){
                if(!visited[neighbor]){
                    q.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }

        return ans;
    }
}
