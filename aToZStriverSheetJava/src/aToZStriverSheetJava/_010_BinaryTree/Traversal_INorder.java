package aToZStriverSheetJava._010_BinaryTree;

import java.util.*;

//link - https://leetcode.com/problems/binary-tree-inorder-traversal/

public class Traversal_INorder {
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

    public List<Integer> inorderTraversal_iterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }

            TreeNode temp = st.pop();
            ans.add(temp.val);

            curr = temp.right;
        }

        return ans;
    }


}
