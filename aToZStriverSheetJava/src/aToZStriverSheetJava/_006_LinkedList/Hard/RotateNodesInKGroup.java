package aToZStriverSheetJava._006_LinkedList.Hard;

import aToZStriverSheetJava._006_LinkedList.ListNode;

//link - https://leetcode.com/problems/reverse-nodes-in-k-group/

public class RotateNodesInKGroup {
    public ListNode findKthNode(ListNode head, int k){
        ListNode kThNode = head;
        for(int i=1; i<k; i++){
            if(kThNode == null){
                return null;
            }
            kThNode = kThNode.next;
        }
        return kThNode;
    }

    public ListNode reverseLL(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while(head != null){
            ListNode kThNode = findKthNode(head, k);
            if(kThNode == null){ // last non-group list
                break;
            }

            ListNode nextGroupStart = kThNode.next;

            kThNode.next = null;
            ListNode reversedGroupHead = reverseLL(head);

            prevGroupEnd.next = reversedGroupHead; // link to prev group
            prevGroupEnd = head; // update tail of last group
            head = nextGroupStart; // new group starts with Head
        }

        prevGroupEnd.next = head;

        return dummy.next;
    }
}
