package aToZStriverSheetJava._010_BinaryTree;

//link - https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

public class Flatten {
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if(root == null){
            return ;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;

        prev = root;

        return ;
    }
}
