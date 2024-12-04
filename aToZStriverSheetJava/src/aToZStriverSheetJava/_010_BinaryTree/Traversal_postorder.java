package aToZStriverSheetJava._010_BinaryTree;

import java.util.*;

public class Traversal_postorder {
    // recusrive

    List<Integer> ans = new ArrayList<>();

    public void solve(TreeNode root){
        if(root == null){
            return ;
        }
        solve(root.left);
        solve(root.right);
        ans.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        solve(root);
        return ans;
    }

    // iterative

    public List<Integer> postorderTraversal_iterative(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            ans.add(curr.val);
            if(curr.left != null){
                st.push(curr.left);
            }
            if(curr.right != null){
                st.push(curr.right);
            }
        }

        Collections.reverse(ans);
        return ans;
    }

}
