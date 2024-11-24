package aToZStriverSheetJava._006_LinkedList;

public class Node {
    public int data;
    public Node next;
    public Node bottom;
    public Node(int data){
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }

    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static int lengthOfLL(Node head){
        if(head == null){
            return 0;
        }
        int cnt = 0;
        Node temp = head;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
}
