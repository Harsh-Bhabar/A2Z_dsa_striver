package aToZStriverSheetJava._12_Graph;

import java.util.*;

//link - https://www.geeksforgeeks.org/problems/topological-sort/1

public class Topological_sort {
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        int V = adj.size();

        int[] indegree = new int[adj.size()];
        for(int i=0; i<V; i++){
            for(int neigh: adj.get(i)){
                indegree[neigh]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);

            for(int neigh: adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.add(neigh);
                }
            }
        }

        return ans;
    }
}
