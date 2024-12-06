package aToZStriverSheetJava._11_BinarySearchTree;

import aToZStriverSheetJava._010_BinaryTree.TreeNode;

//link - https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1

public class Ceil {
    int findCeil(TreeNode root, int key) {
        if (root == null) return -1;
        // Code here
        int ans = -1;
        while(root != null){
            if(root.val == key){
                return key;
            }
            if(root.val > key){
                ans = root.val;
                root = root.left;
            }else{
                root = root.right;
            }
        }

        return ans;
    }
}
