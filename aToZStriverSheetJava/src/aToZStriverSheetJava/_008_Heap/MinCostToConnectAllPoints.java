package aToZStriverSheetJava._008_Heap;

import java.util.PriorityQueue;

//link - https://leetcode.com/problems/min-cost-to-connect-all-points/

public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[0] - b[0] // cost , pointIndex
        );
        minHeap.offer(new int[]{0, 0});

        int n = points.length;
        boolean[] visited = new boolean[n];
        int totalCost = 0;
        int edgesUsed = 0;

        while(edgesUsed < n){
            int[] curr = minHeap.poll();
            int cost = curr[0];
            int pointIndex = curr[1];

            if(visited[pointIndex]){
                continue;
            }

            visited[pointIndex] = true;
            totalCost += cost;
            edgesUsed++;

            // for all unvisited
            for(int i=0; i<n; i++){
                if(!visited[i]){
                    int newCost = Math.abs(points[pointIndex][0]-points[i][0]) +
                            Math.abs(points[pointIndex][1]-points[i][1]);
                    minHeap.offer(new int[]{newCost, i});
                }
            }
        }


        return totalCost;
    }
}
