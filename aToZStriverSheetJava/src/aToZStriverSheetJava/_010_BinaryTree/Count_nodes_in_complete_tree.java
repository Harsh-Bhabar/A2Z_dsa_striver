package aToZStriverSheetJava._010_BinaryTree;

//link - https://leetcode.com/problems/count-complete-tree-nodes/

public class Count_nodes_in_complete_tree {
    public int countNodes(TreeNode root) {

        if(root == null){
            return 0;
        }

        int lh = 1;
        int rh = 1;
        TreeNode leftPtr = root;
        TreeNode rightPtr = root;

        while(leftPtr.left != null){
            lh++;
            leftPtr = leftPtr.left;
        }
        while(rightPtr.right != null){
            rh++;
            rightPtr = rightPtr.right;
        }

        if(lh == rh){
            return (int) Math.pow(2, lh) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
