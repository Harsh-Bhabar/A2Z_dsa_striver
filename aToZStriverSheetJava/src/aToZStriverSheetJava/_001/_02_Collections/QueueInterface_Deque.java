package aToZStriverSheetJava._001._02_Collections;

import java.sql.SQLOutput;
import java.util.ArrayDeque;

public class QueueInterface_Deque {
    public static void main(String[] args){
        ArrayDeque<Integer> adq = new ArrayDeque<>();

//        OFFER - same as offerLast
        adq.offer(25);
//        OFFER FIRST
        adq.offerFirst(10);
//        OFFER LAST
        adq.offerLast(35);

        System.out.println(adq);

//        PEEK - same as PeekFist
        System.out.println("PEEK " + adq.peek());
//        PEEK FIRST
        System.out.println(adq.peekFirst());
//        PEEK LAST
        System.out.println(adq.peekLast());

        System.out.println(adq);

//        POLL
        System.out.println("POLL " + adq.poll());
//        POLL FIRST
        System.out.println(adq.pollFirst());
//        POLL LAST
        System.out.println(adq.pollLast());

        System.out.println(adq);
    }
}
