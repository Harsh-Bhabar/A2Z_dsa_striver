package aToZStriverSheetJava._006_LinkedList.Hard;

import aToZStriverSheetJava._006_LinkedList.Node;

//link - https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=flattening-a-linked-list

public class Flatten_LL {
    Node mergeTwoLL(Node l1, Node l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        Node dummy = new Node(-1);
        Node temp = dummy;

        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                temp.bottom = l1;
                l1 = l1.bottom;
            }
            else{
                temp.bottom = l2;
                l2 = l2.bottom;
            }
            temp.next = null;
            temp = temp.bottom;
        }

        if(l1 != null){
            temp.bottom = l1;
        }
        else if(l2 != null){
            temp.bottom = l2;
        }

        return dummy.bottom;
    }

    Node flatten(Node root) {
        if(root == null || root.next == null){
            return root;
        }

        root.next = flatten(root.next);
        return mergeTwoLL(root, root.next);

    }
}
