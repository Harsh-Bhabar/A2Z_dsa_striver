package aToZStriverSheetJava._12_Graph;

import java.util.PriorityQueue;

//link - https://leetcode.com/problems/min-cost-to-connect-all-points/?envType=problem-list-v2&envId=minimum-spanning-tree

public class MST_cost {
    class Pair{
        int index;
        int weight;
        Pair(int index, int weight){
            this.index = index;
            this.weight = weight;
        }
    }

    class Solution {
        public int minCostConnectPoints(int[][] points) {
            // Minium Spanning tree
            int n = points.length;

            PriorityQueue<Pair> pq = new PriorityQueue<>(
                    (x, y) -> x.weight - y.weight // min heap on weight
            );
            pq.offer(new Pair(0, 0));

            boolean[] visited = new boolean[n];
            int totalCost = 0;
            int edgesUsed = 0;

            while(edgesUsed < n){
                Pair curr = pq.poll();
                int currIndex = curr.index;
                int currCost = curr.weight;

                if(visited[currIndex]){
                    continue;
                }
                visited[currIndex] = true;
                edgesUsed++;
                totalCost += currCost;

                for(int i=0; i<n; i++){
                    if(!visited[i]){
                        int newCost = Math.abs(points[currIndex][0] - points[i][0]) +
                                Math.abs(points[currIndex][1] - points[i][1]);
                        pq.offer(new Pair(i, newCost));
                    }
                }
            }

            return totalCost;
        }
    }
}
