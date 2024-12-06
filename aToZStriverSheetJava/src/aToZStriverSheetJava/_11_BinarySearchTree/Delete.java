package aToZStriverSheetJava._11_BinarySearchTree;

import aToZStriverSheetJava._010_BinaryTree.TreeNode;

//link - https://leetcode.com/problems/delete-node-in-a-bst/

public class Delete {
    public TreeNode findMaxFromLeft(TreeNode root){
        if(root.right == null){
            return root;
        }
        return findMaxFromLeft(root.right);
    }

    public TreeNode delete(TreeNode root){
        // one childs
        if(root.left == null){
            return root.right;
        }
        if(root.right == null){
            return root.left;
        }
        // two child
        TreeNode rightNode = root.right;
        TreeNode maxNodeOfLeft = findMaxFromLeft(root.left);

        maxNodeOfLeft.right = rightNode;
        return root.left;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){
            return delete(root);
        }

        TreeNode temp = root;

        while(root != null){
            if(root.val > key){
                if(root.left != null && root.left.val == key){
                    root.left = delete(root.left);
                    break;
                }else{
                    root = root.left;
                }
            }
            else{
                if(root.right != null && root.right.val == key){
                    root.right = delete(root.right);
                    break;
                }else{
                    root = root.right;
                }
            }
        }

        return temp;
    }
}
