package aToZStriverSheetJava._12_Graph;

import java.util.*;

//link - https://leetcode.com/problems/is-graph-bipartite/

public class Barpartite_check {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);


        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                color[i] = 0;

                while(!q.isEmpty()){
                    int curr = q.poll();

                    for(int neigh: graph[curr]){
                        if(color[neigh] == -1){ // not visited
                            color[neigh] = color[curr] ^ 1;
                            q.offer(neigh);
                        }
                        else if(color[neigh] == color[curr]){
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
