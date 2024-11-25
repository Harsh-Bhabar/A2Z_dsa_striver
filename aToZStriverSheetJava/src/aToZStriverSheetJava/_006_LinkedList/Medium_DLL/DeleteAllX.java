package aToZStriverSheetJava._006_LinkedList.Medium_DLL;

import aToZStriverSheetJava._006_LinkedList.DLLNode;

//link - https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list

public class DeleteAllX {
    static DLLNode deleteAllOccurOfX(DLLNode head, int x) {
        if(head == null){
            return head;
        }

        DLLNode curr = head;
        while(curr != null){
            if(curr.val == x){
                if(curr == head){ // if head
                    head = head.next;
                    if(head != null){
                        head.prev = null;
                    }
                }
                else{
                    if(curr.next != null){
                        curr.next.prev = curr.prev;
                    }
                    if(curr.prev != null){
                        curr.prev.next = curr.next;
                    }
                }
            }

            curr = curr.next;
        }

        return head;
    }
}
