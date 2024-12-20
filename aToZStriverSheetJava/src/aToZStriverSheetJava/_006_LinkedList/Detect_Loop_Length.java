package aToZStriverSheetJava._006_LinkedList;

//link - https://www.geeksforgeeks.org/problems/find-length-of-loop/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-length-of-loop

public class Detect_Loop_Length {
    public int countNodesinLoop(Node head) {
        if(head == null || head.next == null){
            return 0;
        }

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                fast = fast.next;
                int cnt = 1;
                while(fast != slow){
                    fast = fast.next;
                    cnt++;
                }
                return cnt;
            }
        }

        return 0;
    }
}
