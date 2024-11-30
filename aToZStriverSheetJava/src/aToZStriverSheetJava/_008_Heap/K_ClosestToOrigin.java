package aToZStriverSheetJava._008_Heap;

import java.util.PriorityQueue;

//link - https://leetcode.com/problems/k-closest-points-to-origin/

public class K_ClosestToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>( // dist, index
                (a, b) -> b[0] != a[0] ? b[0]-a[0] : a[1] - b[1]
        );

        int i = 0;
        for(int[] point: points){
            int sqSum = (point[0] * point[0]) + (point[1] * point[1]);
            maxHeap.offer(new int[]{sqSum, i});
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
            i++;
        }

        int[][] ans = new int[k][2];
        int ind = 0;
        while(!maxHeap.isEmpty()){
            ans[ind++] = points[maxHeap.poll()[1]];
        }

        return ans;
    }
}
