package aToZStriverSheetJava._010_BinaryTree;

import java.util.*;

//link - https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

public class Traversal_zigZag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean leftToRight = true;

        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> temp = new ArrayList<>();
            while(n-- > 0){
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
            if(leftToRight){
                ans.add(temp);
            }else{
                Collections.reverse(temp);
                ans.add(temp);
            }
            leftToRight = leftToRight == true ? false : true;
        }

        return ans;
    }
}
