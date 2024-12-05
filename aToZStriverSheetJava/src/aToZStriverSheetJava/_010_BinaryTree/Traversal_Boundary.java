package aToZStriverSheetJava._010_BinaryTree;

import java.util.ArrayList;
import java.util.Collections;

public class Traversal_Boundary {
    ArrayList<Integer> ans = new ArrayList<>();

    boolean isLeaf(TreeNode root){
        return root != null && root.left == null && root.right == null;
    }

    public void leftBoundary(TreeNode root){
        while(root != null && !isLeaf(root)){
            ans.add(root.val);
            if(root.left != null){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
    }

    public void rightBoundary(TreeNode root){
        ArrayList<Integer> temp = new ArrayList<>();
        while(root != null && !isLeaf(root)){
            temp.add(root.val);
            if(root.right != null){
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        Collections.reverse(temp);
        ans.addAll(temp);
    }

    public void leaves(TreeNode root){ // inorder
        if(root == null){
            return;
        }
        if(isLeaf(root)){
            ans.add(root.val);
            return ;
        }
        leaves(root.left);
        leaves(root.right);
    }

    ArrayList<Integer> boundaryTraversal(TreeNode root) {
        if(root == null){
            return ans;
        }
        if(isLeaf(root)){
            ans.add(root.val);
            return ans;
        }
        ans.add(root.val);
        leftBoundary(root.left);
        leaves(root);
        rightBoundary(root.right);
        return ans;
    }
}
