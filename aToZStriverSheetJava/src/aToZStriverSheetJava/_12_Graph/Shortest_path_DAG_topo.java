package aToZStriverSheetJava._12_Graph;

import java.util.*;

//link - https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1

public class Shortest_path_DAG_topo {
    class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    class Solution {

        public int[] shortestPath(int V, int E, int[][] edges) {
            // topo sort
            List<List<Pair>> adj = new ArrayList<>();
            int[] indegree = new int[V];

            for(int i=0; i<V; i++){
                adj.add(new ArrayList<>());
            }
            for(int[] e: edges){
                int u = e[0];
                int v = e[1];
                int w = e[2];
                adj.get(u).add(new Pair(v, w));
                indegree[v]++;
            }

            Queue<Integer> q = new LinkedList<>();
            List<Integer> topo = new ArrayList<>();

            for(int i=0; i<V; i++){
                if(indegree[i] == 0){
                    q.offer(i);
                }
            }

            while(!q.isEmpty()){
                int curr = q.poll();
                topo.add(curr);

                for(Pair neigh: adj.get(curr)){
                    indegree[neigh.node]--;
                    if(indegree[neigh.node] == 0){
                        q.offer(neigh.node);
                    }
                }
            }

            // find the distances

            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;

            for(int i=0; i<V; i++){
                int node = topo.get(i);
                if(dist[node] != Integer.MAX_VALUE){
                    for(Pair neigh: adj.get(node)){
                        int v = neigh.node;
                        int w = neigh.weight;

                        if(dist[node] + w < dist[v]){
                            dist[v] = dist[node] + w;
                        }
                    }
                }
            }

            for(int i=0; i<V; i++){
                if(dist[i] == Integer.MAX_VALUE){
                    dist[i] = -1;
                }
            }

            return dist;
        }
    }
}
