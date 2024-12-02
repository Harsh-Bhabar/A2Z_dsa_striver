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


}
