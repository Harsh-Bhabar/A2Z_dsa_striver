package aToZStriverSheetJava._006_LinkedList;

//link - https://leetcode.com/problems/rotate-list/

public class Rotate_K_Right {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }

        ListNode curr = head;
        int len = 1;

        while(curr.next != null){
            curr = curr.next;
            len++;
        }

        if(k % len == 0){
            return head;
        }

        int kPlaces = len - (k % len);
        curr.next = head;

        ListNode temp = head;

        for(int i=1; i<kPlaces; i++){
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}
