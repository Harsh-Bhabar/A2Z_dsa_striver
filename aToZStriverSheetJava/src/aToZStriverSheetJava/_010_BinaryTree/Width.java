package aToZStriverSheetJava._010_BinaryTree;

import java.util.*;

//link - https://leetcode.com/problems/maximum-width-of-binary-tree/

public class Width {
    static class Pair{
        int index;
        TreeNode node;
        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        int ans = 0 ;
        Deque<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            int n = q.size();
            int start = q.peekFirst().index;
            int end = q.peekLast().index;
            // System.out.println("N S E = " + n + " " + start + " " + end);
            ans = Math.max(ans, end-start+1);

            while(n-- > 0){
                Pair pair = q.poll();
                TreeNode curr = pair.node;
                int currInd = pair.index - start;

                if(curr.left != null){
                    q.offer(new Pair(curr.left, 2 * currInd - start));
                }
                if(curr.right != null){
                    q.offer(new Pair(curr.right, 2 * currInd + 1 - start));
                }
            }
        }

        return ans;
    }
}
