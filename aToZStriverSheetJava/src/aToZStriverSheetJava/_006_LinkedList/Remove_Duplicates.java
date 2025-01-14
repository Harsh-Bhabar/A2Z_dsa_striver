package aToZStriverSheetJava._006_LinkedList;

//link - https://leetcode.com/problems/remove-duplicates-from-sorted-list/

public class Remove_Duplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = head;

        while(curr != null){
            ListNode nextNode = curr.next;
            while(nextNode != null && curr.val == nextNode.val){
                nextNode = nextNode.next;
            }
            curr.next = nextNode;
            curr = nextNode;
        }

        return head;
    }
}
