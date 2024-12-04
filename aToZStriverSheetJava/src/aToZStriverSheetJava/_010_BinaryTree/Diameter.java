package aToZStriverSheetJava._010_BinaryTree;

// link - https://leetcode.com/problems/diameter-of-binary-tree/

public class Diameter {
    int diameter = Integer.MIN_VALUE;

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        diameter = Math.max(diameter, lh+rh);

        return 1 + Math.max(lh, rh);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        height(root);
        return diameter;
    }
}
