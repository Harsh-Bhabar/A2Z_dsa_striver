package aToZStriverSheetJava._006_LinkedList.Easy_DLL;

import aToZStriverSheetJava._006_LinkedList.DLLNode;

import java.util.ArrayList;
import java.util.Arrays;

public class Insert_Delete_Front_Nth_back {

    public static DLLNode makeDLLFromArr(ArrayList<Integer> nums){
        DLLNode dummy = new DLLNode(-1);
        DLLNode temp = dummy;
        for(int num: nums){
            DLLNode newNode = new DLLNode(num);
            temp.next = newNode;
            newNode.prev = temp;
            temp = temp.next;
        }
        return dummy.next;
    }

    public static DLLNode insertAtEnd(DLLNode head, DLLNode newNode){
        if(head == null){
            return newNode;
        }
        DLLNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }

    public static DLLNode insertAtBeginning(DLLNode head, DLLNode newNode){
        if(head == null){
            return newNode;
        }
        head.prev = newNode;
        newNode.next = head;

        return newNode;
    }

    public static DLLNode insertAtNthPlace(DLLNode head, DLLNode newNode, int n){
        if(n == 0 || head == null){
            return insertAtBeginning(head, newNode);
        }
        DLLNode temp = head;
        int cnt = 1;
        while(cnt < n && temp != null){
            temp = temp.next;
            cnt++;
        }
        if(temp != null && temp.next != null){
            DLLNode nextNode = temp.next;
            temp.next = newNode;
            newNode.next = nextNode;
            newNode.prev = temp;
            nextNode.prev = newNode;
        }else{
            return insertAtEnd(head, newNode);
        }
        return head;
    }

    public static DLLNode deleteAtFront(DLLNode head){
        if(head == null || head.next == null){
            return null;
        }
        return head.next;
    }

    public static DLLNode deleteAtEnd(DLLNode head){
        if(head == null || head.next == null){
            return null;
        }
        DLLNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.prev.next = null;
        return head;
    }

    public static DLLNode deleteNthNode(DLLNode head, int n){
        if(head == null || n <= 0){
            return head;
        }
        if(n == 1){
            return deleteAtFront(head);
        }
        DLLNode temp = head;
        int cnt = 1;
        while(temp != null && cnt < n){
            temp = temp.next;
            cnt++;
        }

        if(temp == null){
            return head;
        }

        if(temp.next == null){
            return deleteAtEnd(head);
        }else{
            DLLNode next2next = temp.next.next;
            temp.next = next2next;
            if(next2next != null){
                next2next.prev = temp;
            }
        }

        return head;
    }

    public static void printDLL(DLLNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        DLLNode head = makeDLLFromArr(nums);
        printDLL(head);

        head = insertAtEnd(head, new DLLNode(6));
        head = insertAtEnd(head, new DLLNode(7));
        printDLL(head);

        head = insertAtBeginning(head, new DLLNode(-1));
        head = insertAtBeginning(head, new DLLNode(-2));
        printDLL(head);

        head = insertAtNthPlace(head,  new DLLNode(100), 3);
        head = insertAtNthPlace(head,  new DLLNode(100), 20);
        printDLL(head);

        head = deleteAtFront(head);
        printDLL(head);

        head = deleteAtEnd(head);
        head = deleteAtEnd(head);
        printDLL(head);

        head = deleteNthNode(head, 4);
        printDLL(head);

    }
}
