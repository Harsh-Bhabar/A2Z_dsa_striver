package aToZStriverSheetJava._006_LinkedList;

//link - https://leetcode.com/problems/swap-nodes-in-pairs/

public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;

        while(prev.next != null && prev.next.next != null){
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
        }

        return dummy.next;
    }
}
