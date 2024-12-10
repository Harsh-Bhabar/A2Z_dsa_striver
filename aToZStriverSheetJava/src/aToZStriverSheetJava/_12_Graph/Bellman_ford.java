package aToZStriverSheetJava._12_Graph;

import java.util.Arrays;

//link - https://leetcode.com/problems/cheapest-flights-within-k-stops/

public class Bellman_ford {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // bellman ford

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;


        // k+1 iterations
        for(int i=0; i<=k; i++){
            int[] temp = Arrays.copyOf(dist, n);

            for(int[] flight: flights){
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                // relaxing
                if(dist[from] != Integer.MAX_VALUE && dist[from] + price < temp[to]){
                    temp[to] = dist[from] + price;
                }
            }
            //update original
            dist = temp;
        }

        // for(int i)

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
