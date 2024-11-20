package aToZStriverSheetJava._006_LinkedList.Easy;

import aToZStriverSheetJava._006_LinkedList.Node;

public class SearchLinear {
    static boolean searchKey(int n, Node head, int key) {
        // Code here
        if(head == null){
            return false;
        }
        while(head.next != null){
            if(head.data == key){
                return true;
            }
            head = head.next;
        }

        return false;
    }
}
