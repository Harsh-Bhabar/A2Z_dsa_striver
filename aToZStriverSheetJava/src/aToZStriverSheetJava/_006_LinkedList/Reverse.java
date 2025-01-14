package aToZStriverSheetJava._006_LinkedList;

//link - https://leetcode.com/problems/reverse-linked-list/

public class Reverse {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
