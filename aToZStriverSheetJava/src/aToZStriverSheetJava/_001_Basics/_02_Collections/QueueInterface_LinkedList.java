package aToZStriverSheetJava._001_Basics._02_Collections;

import java.util.Queue;
import java.util.LinkedList;

public class QueueInterface_LinkedList {
    public static void main(String[] args) {
        // Queue - using LinkedList
        Queue<String> queue = new LinkedList<>();
        // OFFER - insert
        queue.offer("Harsh");
        queue.offer("Ayush");
        queue.offer("Saket");

        System.out.println(queue);

        // POLL - remove and return
        System.out.println(queue.poll());
        System.out.println(queue);

        // PEEK - top
        System.out.println(queue.peek());

    }
}
