package aToZStriverSheetJava._11_BinarySearchTree;

import aToZStriverSheetJava._010_BinaryTree.TreeNode;

import java.util.Stack;

//link - https://leetcode.com/problems/binary-search-tree-iterator/

public class BST_Iterator {

    Stack<TreeNode> st;

    public void pushAllToLeft(TreeNode root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }

    public void BSTIterator(TreeNode root) {
        st = new Stack<>();
        pushAllToLeft(root);
    }

    public int next() {
        TreeNode top = st.pop();
        if(top.right != null){
            pushAllToLeft(top.right);
        }
        return top.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
}
