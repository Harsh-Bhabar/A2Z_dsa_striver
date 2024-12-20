package aToZStriverSheetJava._006_LinkedList;

//link - https://leetcode.com/problems/palindrome-linked-list/description/

public class Palindrome_check {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }

        // move to mid
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse from mid to end
        ListNode prev = null;
        ListNode curr = slow;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode tail = prev;

        while(head != null && tail != null){
            if(head == null){
                return true;
            }
            else if(head.val != tail.val){
                return false;
            }
            head = head.next;
            tail = tail.next;
        }

        return true;
    }
}
