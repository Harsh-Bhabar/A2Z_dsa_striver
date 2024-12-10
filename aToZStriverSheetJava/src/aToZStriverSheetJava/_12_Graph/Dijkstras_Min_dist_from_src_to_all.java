package aToZStriverSheetJava._12_Graph;

//link - https://leetcode.com/problems/network-delay-time/description/

import java.util.*;

public class Dijkstras_Min_dist_from_src_to_all {
    class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    class Solution {
        public int networkDelayTime(int[][] times, int n, int src) {
            n += 1;
            PriorityQueue<Pair> pq = new PriorityQueue<>(
                    (x, y) -> x.weight - y.weight // min heap -> wights
            );

            List<List<Pair>> adj = new ArrayList<>();
            for(int i=0; i<n; i++){
                adj.add(new ArrayList<>());
            }
            for(int[] edge: times){
                adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            }

            int dist[] = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;
            pq.offer(new Pair(src, 0));

            while(!pq.isEmpty()){
                Pair curr = pq.poll();
                for(Pair neigh: adj.get(curr.node)){
                    if(dist[neigh.node] > curr.weight + neigh.weight){
                        dist[neigh.node] = curr.weight + neigh.weight;
                        pq.offer(new Pair(neigh.node, dist[neigh.node]));
                    }
                }
            }

            // find max here -> that will be the min time to reach ALL nodes
            int ans = Arrays.stream(dist, 1, dist.length).max().orElse(1);

            return ans == Integer.MAX_VALUE ? -1 : ans;

        }
    }
}
