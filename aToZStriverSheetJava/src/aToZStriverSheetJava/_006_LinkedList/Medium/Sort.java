package aToZStriverSheetJava._006_LinkedList.Medium;

import aToZStriverSheetJava._006_LinkedList.ListNode;

//link - https://leetcode.com/problems/sort-list/

public class Sort {
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeTwoSortedLL(ListNode left, ListNode right){
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        ListNode head1 = left;
        ListNode head2 = right;

        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                temp.next = head1;
                head1 = head1.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if(head1 != null){
            temp.next = head1;
        }
        else if(head2 != null){
            temp.next = head2;
        }

        return dummyNode.next;
    }

    public ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMid(head);
        ListNode rightHead = mid.next;
        mid.next = null;
        ListNode leftHead = head;

        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);

        return mergeTwoSortedLL(leftHead, rightHead);
    }

    public ListNode sortList(ListNode head) {
        // merge Sort
        return mergeSort(head);
    }
}
