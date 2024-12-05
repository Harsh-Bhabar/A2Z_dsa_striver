package aToZStriverSheetJava._010_BinaryTree;

//link - https://leetcode.com/problems/symmetric-tree/

public class Symmetric_tree {
    public boolean isIdentical(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val
                && isIdentical(p.left, q.right)
                && isIdentical(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isIdentical(root.left, root.right);
    }
}
