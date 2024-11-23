package aToZStriverSheetJava._006_LinkedList.Medium;

import aToZStriverSheetJava._006_LinkedList.Node;

//link - https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=add-1-to-a-number-represented-as-linked-list

public class Add_1_Digit {
    public Node reverseLL(Node head){
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node addOne(Node head) {
        head = reverseLL(head);

        Node curr = head;
        int carry = 1;

        while(curr != null){
            int sum = curr.data + carry;
            curr.data = sum % 10;
            carry = sum / 10;
            if(carry == 0){
                break;
            }
            if(curr.next == null && carry > 0){
                Node newNode = new Node(carry);
                curr.next = newNode;
                carry = 0;
            }
            curr = curr.next;
        }

        return reverseLL(head);
    }
}
