package aToZStriverSheetJava._010_BinaryTree;

//link - https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

import java.util.*;

public class Contruct_from_POSTorder {

    Map<Integer, Integer> postorderMap = new HashMap<>();
    int postPos;

    public TreeNode solve(int[] postorder, int[] inorder, int l, int r){
        if(l > r){
            return null;
        }

        TreeNode newNode = new TreeNode(postorder[postPos--]);
        int inorderPos = postorderMap.get(newNode.val);

        newNode.right = solve(postorder, inorder, inorderPos+1, r);
        newNode.left = solve(postorder, inorder, l, inorderPos-1);

        return newNode;
    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i<inorder.length; i++){
            postorderMap.put(inorder[i], i);
        }

        postPos = postorder.length - 1;
        return solve(postorder, inorder, 0, inorder.length-1);
    }
}
