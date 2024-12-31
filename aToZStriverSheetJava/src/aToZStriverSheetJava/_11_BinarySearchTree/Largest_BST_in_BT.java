package aToZStriverSheetJava._11_BinarySearchTree;

import aToZStriverSheetJava._010_BinaryTree.TreeNode;

//link - https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

public class Largest_BST_in_BT {

    class NodeInfo{
        int sum;
        int size;
        int min;
        int max;
        boolean isBST ;
        NodeInfo(int sum, int size, int min, int max, boolean isBST){
            this.sum = sum;
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    class Solution {
        int maxSum = 0;
        int maxSize = 0;

        public NodeInfo solve(TreeNode root){
            if(root == null){
                return new NodeInfo(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            }

            NodeInfo left = solve(root.left);
            NodeInfo right = solve(root.right);

            if(left.isBST && right.isBST && left.max < root.val && root.val < right.min){
                int currSum = left.sum + root.val + right.sum;
                int currSize = 1 + left.size + right.size;
                maxSum = Math.max(maxSum, currSum);
                return new NodeInfo(
                        currSum,
                        currSize,
                        Math.min(root.val, left.min),
                        Math.max(root.val, right.max),
                        true);
            }else{
                return new NodeInfo(
                        0,
                        Math.max(left.size, right.size),
                        0,
                        0,
                        false
                );
            }
        }

        public int maxSumBST(TreeNode root) {
            solve(root);
            return maxSum;
        }
    }
}
