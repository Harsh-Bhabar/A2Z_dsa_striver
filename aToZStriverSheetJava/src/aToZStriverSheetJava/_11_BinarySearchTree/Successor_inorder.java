package aToZStriverSheetJava._11_BinarySearchTree;

import aToZStriverSheetJava._010_BinaryTree.TreeNode;

public class Successor_inorder {
    int succ = -1;

    public void solve(TreeNode root, TreeNode x){
        while(root != null){
            if(root.val > x.val){
                succ = root.val;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
    }

    public int inorderSuccessor(TreeNode root, TreeNode x) {
        solve(root, x);
        return succ;
    }
}
