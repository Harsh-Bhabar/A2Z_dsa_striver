package aToZStriverSheetJava._001_Basics._02_Collections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueInterface_PriorityQueue {
    public static void main(String[] args){
//        PriorityQueue<Integer> pq = new PriorityQueue<>(); // MIN HEAP
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // MAX HEAP

        // OFFER - insert
        pq.offer(43);
        pq.offer(4);
        pq.offer(45);
        pq.offer(8);

        System.out.println(pq);

        // POLL - remove and return
        System.out.println(pq.poll());
        System.out.println(pq);

        // PEEK - top
        System.out.println(pq.peek());

    }
}
