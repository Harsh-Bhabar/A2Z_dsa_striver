package aToZStriverSheetJava._006_LinkedList.Medium;

import aToZStriverSheetJava._006_LinkedList.Node;

//link - https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=given-a-linked-list-of-0s-1s-and-2s-sort-it

public class Sort_0_1_2 {

    static Node segregate(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        Node curr = head;
        Node zeroHead = new Node(-1);
        Node zero = zeroHead;
        Node oneHead = new Node(-1);
        Node one = oneHead;
        Node twoHead = new Node(-1);
        Node two = twoHead;

        while(curr != null){
            if(curr.data == 0){
                zero.next = curr;
                zero = curr;
            }
            else if(curr.data == 1){
                one.next = curr;
                one = curr;
            }
            else if(curr.data == 2){
                two.next = curr;
                two = curr;
            }
            curr = curr.next;
        }

        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        Node newHead = zeroHead.next;

        return newHead;
    }
}
