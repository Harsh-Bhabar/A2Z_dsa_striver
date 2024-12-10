package aToZStriverSheetJava._12_Graph;

import java.util.*;

//link - https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/0

public class Shortest_path_from_src_UNDIR {

    class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    class Solution {

        public int[] shortestPath(int[][] edges,int n,int m ,int src) {
            List<List<Pair>> adj = new ArrayList<>();
            for(int i=0; i<n; i++){
                adj.add(new ArrayList<>());
            }

            for(int[] edge: edges){
                adj.get(edge[0]).add(new Pair(edge[1], 1));
                adj.get(edge[1]).add(new Pair(edge[0], 1));
            }

            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(src, 0));
            dist[src] = 0;

            while(!q.isEmpty()){
                Pair curr = q.poll();
                for(Pair neigh: adj.get(curr.node)){
                    if(dist[curr.node] + 1 < dist[neigh.node]){
                        dist[neigh.node] = dist[curr.node] + 1;
                        q.offer(new Pair(neigh.node, dist[neigh.node]));
                    }
                }
            }

            for(int i=0; i<n; i++){
                if(dist[i] == Integer.MAX_VALUE){
                    dist[i] = -1;
                }
            }

            return dist;

        }
    }
}
