package aToZStriverSheetJava._010_BinaryTree;

//link -https://leetcode.com/problems/maximum-depth-of-binary-tree/

public class Height {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1+Math.max(lh, rh);
    }
}
