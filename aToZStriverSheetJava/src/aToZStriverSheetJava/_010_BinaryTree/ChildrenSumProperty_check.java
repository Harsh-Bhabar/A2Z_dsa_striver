package aToZStriverSheetJava._010_BinaryTree;

//link - https://www.geeksforgeeks.org/problems/children-sum-parent/1

public class ChildrenSumProperty_check {
    public static boolean solve(TreeNode root){
        if(root == null){
            return true;
        }
        int sum = 0;
        if(root.left != null){
            sum += root.left.val;
        }
        if(root.right != null){
            sum += root.right.val;
        }

        if((root.left != null || root.right != null) && sum != root.val){
            return false;
        }

        return solve(root.left) && solve(root.right);
    }

    public static int isSumProperty(TreeNode root)
    {
        if(root == null){
            return 1;
        }

        return solve(root) ? 1 : 0;
    }
}
