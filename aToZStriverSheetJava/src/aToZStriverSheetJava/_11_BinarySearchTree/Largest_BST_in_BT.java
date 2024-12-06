package aToZStriverSheetJava._11_BinarySearchTree;

import aToZStriverSheetJava._010_BinaryTree.TreeNode;

//link - https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

public class Largest_BST_in_BT {

    class Node{
        int size;
        int sum;
        int max;
        int min;
        Node(int size, int sum, int max, int min){
            this.size = size;
            this.sum = sum;
            this.max = max;
            this.min = min;
        }
    }

    int maxSum = 0;

    public Node solve(TreeNode node){
        if(node == null){
            return new Node(0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Node left = solve(node.left);
        Node right = solve(node.right);
        // for a valid BST -> largest from left < node < smallest from right
        if(left.max < node.val && node.val < right.min){
            maxSum = Math.max(maxSum, left.sum + node.val + right.sum);

            return new Node(
                    1 + left.size + right.size, // size
                    node.val + left.sum + right.sum, // sum
                    Math.max(right.max, node.val), // max
                    Math.min(left.min, node.val) // min
            );
        }else{
            return new Node(
                    Math.max(left.size, right.size), // size
                    0, // sum
                    Integer.MAX_VALUE, // max
                    Integer.MIN_VALUE // min
            );
        }
    }

    public int maxSumBST(TreeNode root) {
        // POST ORDER
        if(root == null){
            return 0;
        }
        Node ans = solve(root);
        // if we need max size of BST we can just do ans.size
        return maxSum;
    }
}
