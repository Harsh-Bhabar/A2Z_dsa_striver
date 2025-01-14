package aToZStriverSheetJava._006_LinkedList;

import java.util.*;

//link - https://leetcode.com/problems/merge-k-sorted-lists/

public class Merge_K_sorted_listss {

    // O(nlogK) - T || O(k) - S | N - number of elements | K - number of lists

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                (a, b) -> a.val - b.val
        );

        for(ListNode list: lists){
            if(list != null){
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode(1);
        ListNode temp = dummy;

        while(!minHeap.isEmpty()){
            ListNode smallestHead = minHeap.poll();
            temp.next = smallestHead;
            temp = temp.next;

            if(smallestHead.next != null){
                minHeap.offer(smallestHead.next);
            }
        }

        return dummy.next;
    }

    // merge Sort
    // O(nlogK) - T || O(logk) - S | N - number of elements | K - number of lists

    public ListNode mergeTwoLL(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = l1;
                l1 = l1.next;
            }else{
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1 != null){
            temp.next = l1;
        }
        if(l2 != null){
            temp.next = l2;
        }

        return dummy.next;
    }

    public ListNode mergeSort(int l, int r, ListNode[] lists){
        if(l > r){
            return null;
        }
        if(l == r){
            return lists[l];
        }
        int mid = (l + r)/ 2;
        ListNode leftHead = mergeSort(l, mid, lists);
        ListNode rightHead = mergeSort(mid+1, r, lists);

        return mergeTwoLL(leftHead, rightHead);
    }

    public ListNode mergeKLists_2(ListNode[] lists) {
        return mergeSort(0, lists.length-1, lists);
    }
}
