package aToZStriverSheetJava._12_Graph;

import java.util.*;

//link - https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

public class CycleDetect_Directed_KahnsAlgo {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] indegree = new int[V];
        for(int i=0; i<V; i++){
            for(int ad: adj.get(i)){
                indegree[ad]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int cnt = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            cnt++;

            for(int neigh: adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }

        return cnt != V;
    }
}
