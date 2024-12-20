package aToZStriverSheetJava._006_LinkedList;

//link - https://leetcode.com/problems/remove-nth-node-from-end-of-list/

public class Delete_Nth {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        for(int i=0; i<n; i++){
            fast = fast.next;
        }

        // if k = len of LL
        if(fast == null){
            return head.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
