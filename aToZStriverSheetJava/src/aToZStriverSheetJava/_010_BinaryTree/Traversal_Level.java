package aToZStriverSheetJava._010_BinaryTree;

//link - https://leetcode.com/problems/binary-tree-level-order-traversal/

import java.util.*;

public class Traversal_Level {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

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
            ans.add(temp);
        }

        return ans;
    }
}
