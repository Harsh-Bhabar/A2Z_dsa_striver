package aToZStriverSheetJava._11_BinarySearchTree;

import aToZStriverSheetJava._010_BinaryTree.TreeNode;

//link - https://leetcode.com/problems/validate-binary-search-tree/

public class Validate_BST {
    public boolean validate(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        System.out.println("ROOT MIN MAX " + root.val + " " + min + " " + max);
        return validate(root.left, min, root.val)
                && validate(root.right, root.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
