package aToZStriverSheetJava._010_BinaryTree;

import java.util.*;

//link - https://leetcode.com/problems/binary-tree-inorder-traversal/

public class Traversal_inorder {
    // recursive
    List<Integer> ans = new ArrayList<>();

    public void solve(TreeNode root){
        if(root == null){
            return;
        }
        solve(root.left);
        ans.add(root.val);
        solve(root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        solve(root);
        return ans;
    }


    // iterative


}
