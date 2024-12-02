package aToZStriverSheetJava._010_BinaryTree;

import java.util.ArrayList;
import java.util.List;

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

}
