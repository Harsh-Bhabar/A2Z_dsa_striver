package aToZStriverSheetJava._006_LinkedList.Medium;

import aToZStriverSheetJava._006_LinkedList.ListNode;

public class MiddleOfLL {
    public ListNode middleNode(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}