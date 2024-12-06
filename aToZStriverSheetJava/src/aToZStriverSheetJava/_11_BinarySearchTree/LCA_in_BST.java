package aToZStriverSheetJava._11_BinarySearchTree;

import aToZStriverSheetJava._010_BinaryTree.TreeNode;

//link - https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

public class LCA_in_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            // both in left side
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            }
            // both in right side
            else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }
            // ans
            else{
                return root;
            }
        }
        return null;
    }
}
