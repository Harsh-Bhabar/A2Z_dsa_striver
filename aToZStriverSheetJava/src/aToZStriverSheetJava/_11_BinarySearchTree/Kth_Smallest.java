package aToZStriverSheetJava._11_BinarySearchTree;

import aToZStriverSheetJava._010_BinaryTree.TreeNode;

//link - https://leetcode.com/problems/kth-smallest-element-in-a-bst/

public class Kth_Smallest {
    int cnt = 0;

    public int solve(TreeNode root, int k){
        if(root == null){
            return -1;
        }
        int left = solve(root.left, k);
        if(left != -1){
            return left;
        }
        cnt++;
        if(cnt == k){
            return root.val;
        }
        return solve(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        // inorder traversal of BST gives sorted array
        return solve(root, k);
    }
}
