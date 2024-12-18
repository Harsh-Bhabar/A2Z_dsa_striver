package aToZStriverSheetJava._006_LinkedList.Medium_DLL;

import aToZStriverSheetJava._006_LinkedList.DLLNode;

import java.util.ArrayList;
import java.util.Arrays;

public class Pairs_With_Given_Sum_K {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, DLLNode head) {
        if(head == null || head.next == null){
            return new ArrayList<>();
        }

        DLLNode left = head;
        DLLNode right = head;
        while(right.next != null){
            right = right.next;
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while(left != right && left.prev != right){
            int sum = left.val + right.val;
            if(sum == target){
                ans.add(new ArrayList(Arrays.asList(left.val, right.val)));
                left = left.next;
                right = right.prev;
            }
            else if(sum < target){
                left = left.next;
            }
            else{
                right = right.prev;
            }
        }

        return ans;
    }
}
