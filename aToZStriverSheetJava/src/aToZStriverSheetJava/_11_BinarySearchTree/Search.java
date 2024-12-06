package aToZStriverSheetJava._11_BinarySearchTree;

import aToZStriverSheetJava._010_BinaryTree.TreeNode;

//link - https://leetcode.com/problems/search-in-a-binary-search-tree/

public class Search {
    // iterative
    public TreeNode searchBST_iter(TreeNode root, int val) {
        while(root != null && root.val != val){
            root = root.val < val ? root.right : root.left;
        }
        return root;
    }
    // recursive
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        if(root.val < val){
            return searchBST(root.right, val);
        }
        return searchBST(root.left, val);
    }
}
