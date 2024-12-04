package aToZStriverSheetJava._010_BinaryTree;

//link - https://leetcode.com/problems/binary-tree-maximum-path-sum/

public class Maximum_Path_Sum {
    int ans = Integer.MIN_VALUE;

    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        int oneSideSum = Math.max(root.val , root.val + Math.max(leftSum, rightSum));
        int twoSideSum = Math.max(leftSum + root.val + rightSum, oneSideSum);
        ans = Math.max(ans, twoSideSum);

        return oneSideSum;
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }
}
