package aToZStriverSheetJava._010_BinaryTree;

import java.util.*;

//link - https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

public class Construct_from_PREORDER {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int prePos = 0;

    public TreeNode solve(int[] preorder, int[] inorder, int l, int r){
        if(l > r){
            return null;
        }

        TreeNode newNode = new TreeNode(preorder[prePos++]);
        int inorderPos = inorderMap.get(newNode.val);

        newNode.left = solve(preorder, inorder, l, inorderPos-1);
        newNode.right = solve(preorder, inorder, inorderPos+1, r);

        return newNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }

        return solve(preorder, inorder, 0, inorder.length-1);
    }
}
