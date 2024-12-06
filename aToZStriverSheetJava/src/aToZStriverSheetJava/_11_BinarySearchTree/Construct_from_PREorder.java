package aToZStriverSheetJava._11_BinarySearchTree;

import aToZStriverSheetJava._010_BinaryTree.TreeNode;

//link - https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/

public class Construct_from_PREorder {
    public TreeNode insertIntoBST(TreeNode root, int key){
        if(root == null){
            return new TreeNode(key);
        }
        if(root.val > key){
            root.left = insertIntoBST(root.left, key);
        }else{
            root.right = insertIntoBST(root.right, key);
        }
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0){
            return null;
        }
        TreeNode head = new TreeNode(preorder[0]);
        for(int i=1; i<preorder.length; i++){
            insertIntoBST(head, preorder[i]);
        }
        return head;
    }
}
