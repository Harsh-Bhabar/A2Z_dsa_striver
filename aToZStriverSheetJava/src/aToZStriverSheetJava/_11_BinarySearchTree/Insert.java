package aToZStriverSheetJava._11_BinarySearchTree;

import aToZStriverSheetJava._010_BinaryTree.TreeNode;

//link - https://leetcode.com/problems/insert-into-a-binary-search-tree/submissions/1471984334/

public class Insert {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        if(root.val < val){
            root.right = insertIntoBST(root.right, val);
        }else{
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}
