package aToZStriverSheetJava._010_BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal_preorder {

    // recursive
    List<Integer> ans = new ArrayList<>();

    public void solve(TreeNode root){
        if(root == null){
            return ;
        }
        ans.add(root.val);
        solve(root.left);
        solve(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        solve(root);
        return ans;
    }

    // iterative
    public List<Integer> preorderTraversal_iterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            ans.add(curr.val);
            if(curr.right != null){
                st.push(curr.right);
            }
            if(curr.left != null){
                st.push(curr.left);
            }
        }

        return ans;
    }
}
