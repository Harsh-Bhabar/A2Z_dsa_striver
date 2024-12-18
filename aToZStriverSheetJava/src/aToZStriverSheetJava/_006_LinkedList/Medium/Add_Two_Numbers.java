package aToZStriverSheetJava._006_LinkedList.Medium;

import aToZStriverSheetJava._006_LinkedList.ListNode;

//link - https://leetcode.com/problems/add-two-numbers/

public class Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;

            ListNode nextNode = new ListNode(sum % 10);
            temp.next = nextNode;
            temp = temp.next;
        }

        return dummyNode.next;
    }
}
