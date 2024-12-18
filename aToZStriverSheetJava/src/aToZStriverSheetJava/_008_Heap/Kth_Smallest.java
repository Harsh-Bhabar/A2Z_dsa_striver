package aToZStriverSheetJava._008_Heap;

import java.util.PriorityQueue;

//link - https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=kth-smallest-element

public class Kth_Smallest {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);

        for(int i=0; i<arr.length; i++){
            pq.offer(arr[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}
