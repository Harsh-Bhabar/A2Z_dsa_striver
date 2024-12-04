package aToZStriverSheetJava._010_BinaryTree;

//link - https://leetcode.com/problems/balanced-binary-tree/

public class Balanced_BT {
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        if(Math.abs(lh-rh) > 1 || lh == -1 || rh == -1){
            return -1;
        }

        return 1 + Math.max(lh, rh);
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return height(root) != -1;
    }
}
