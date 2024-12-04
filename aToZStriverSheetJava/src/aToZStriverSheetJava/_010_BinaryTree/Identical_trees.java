package aToZStriverSheetJava._010_BinaryTree;

//link - https://leetcode.com/problems/same-tree/

public class Identical_trees {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return p.val == q.val &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }
}
