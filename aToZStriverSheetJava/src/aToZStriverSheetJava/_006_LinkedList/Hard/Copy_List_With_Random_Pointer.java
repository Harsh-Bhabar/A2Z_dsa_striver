package aToZStriverSheetJava._006_LinkedList.Hard;

//link - https://leetcode.com/problems/copy-list-with-random-pointer/

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }

        // add in btw
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // add random
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // re arrange
        Node original = head;
        Node copy = head.next;
        Node copyHead = copy;

        while(original != null){
            original.next = original.next.next;
            if(copy.next != null){
                copy.next = copy.next.next;
            }
            original = original.next;
            copy = copy.next;
        }

        return copyHead;
    }
}
