package aToZStriverSheetJava._11_BinarySearchTree;

import aToZStriverSheetJava._010_BinaryTree.TreeNode;

public class Floor {
    public static int floor(TreeNode root, int x) {
        int ans = -1;
        while(root != null){
            if(root.val == x){
                return root.val;
            }
            if(root.val < x){
                ans = root.val;
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return ans;
    }
}
