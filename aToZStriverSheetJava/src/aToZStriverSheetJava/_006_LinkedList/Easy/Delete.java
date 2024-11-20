package aToZStriverSheetJava._006_LinkedList.Easy;

import aToZStriverSheetJava._006_LinkedList.Node;
import static aToZStriverSheetJava._006_LinkedList.Node.printLL;
import aToZStriverSheetJava._006_LinkedList.Easy.Insert;

public class Delete {
    public Node deleteAtEnd(Node head){
        if(head == null){
            return head;
        }
        Node temp = head;
        while(temp.next != null && temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public Node deleteAtHead(Node head){
        if(head == null){
            return head;
        }
        head = head.next;
        return head;
    }

    public void deleteWithoutHead(Node node){
        if(node == null || node.next == null){
            return;
        }

        node.data = node.next.data;
        node.next = node.next.next;
        return;
    }

    public static void main(String[] args){
        Insert list = new Insert();
        Node head = null;
        head = list.insertAtEnd(head, 1);
        head = list.insertAtEnd(head, 2);
        head = list.insertAtEnd(head, 3);

        printLL(head);

        Delete d = new Delete();

        head = d.deleteAtEnd(head);
        printLL(head);

        head = d.deleteAtHead(head);
        printLL(head);

        head = list.insertAtEnd(head, 4);
        head = list.insertAtEnd(head, 5);
        printLL(head);

        d.deleteWithoutHead(head.next);
        printLL(head);

    }

}
