package aToZStriverSheetJava._006_LinkedList.Easy;

import aToZStriverSheetJava._006_LinkedList.Node;
import static aToZStriverSheetJava._006_LinkedList.Node.printLL;

public class Insert {
    public Node insertAtEnd(Node head, int x){
        Node newNode = new Node(x);
        if(head == null){
            return newNode;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public Node insertAtHead(Node head, int x){
        Node newNode = new Node(x);
        newNode.next = head;
        return newNode;
    }

    public static void main(String[] args){
        Insert list = new Insert();
        Node head = null;
        head = list.insertAtEnd(head, 1);
        head = list.insertAtEnd(head, 2);
        head = list.insertAtEnd(head, 3);
        head = list.insertAtEnd(head, 5);
        head = list.insertAtHead(head, -1);
        head = list.insertAtHead(head, -3);

        printLL(head);
    }
}
