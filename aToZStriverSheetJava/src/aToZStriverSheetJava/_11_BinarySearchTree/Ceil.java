package aToZStriverSheetJava._11_BinarySearchTree;

import aToZStriverSheetJava._010_BinaryTree.TreeNode;

//link - https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1

public class Ceil {
    int ceil = -1;

    int solve(TreeNode root, int key){
        if(root == null){
            return ceil;
        }
        if(root.val == key){
            ceil = key;
            return ceil;
        }
        if(root.val > key){
            ceil = root.val;
            return solve(root.left, key);
        }
        return solve(root.right, key);
    }

    int findCeil(TreeNode root, int key) {
        if (root == null) return -1;
        // Code here
        return solve(root, key);
    }
}
