package aToZStriverSheetJava._11_BinarySearchTree;

import aToZStriverSheetJava._010_BinaryTree.TreeNode;

//link - https://leetcode.com/problems/recover-binary-search-tree/

public class Recover_BST {
    TreeNode first;
    TreeNode middle;
    TreeNode last;
    TreeNode prev;

    public void inorder(TreeNode root){
        if(root == null){
            return ;
        }
        inorder(root.left);

        if(prev != null && root.val < prev.val){
            if(first == null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }

        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        first = last = middle = null;
        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);

        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else if(first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
}
