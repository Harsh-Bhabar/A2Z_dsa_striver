package aToZStriverSheetJava._11_BinarySearchTree;

import aToZStriverSheetJava._010_BinaryTree.TreeNode;

//link - https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

import java.util.Stack;

public class Two_Sum {
    Stack<TreeNode> nextSt = new Stack<>();
    Stack<TreeNode> prevSt = new Stack<>();

    public void pushAllLeft(TreeNode curr){
        while(curr != null){
            nextSt.push(curr);
            curr = curr.left;
        }
    }

    public void pushAllRight(TreeNode curr){
        while(curr != null){
            prevSt.push(curr);
            curr = curr.right;
        }
    }

    public int getNext(){
        TreeNode top = nextSt.pop();
        if(top.right != null){
            pushAllLeft(top.right);
        }
        return top.val;
    }

    public int getPrev(){
        TreeNode top = prevSt.pop();
        if(top.left != null){
            pushAllRight(top.left);
        }
        return top.val;
    }

    public boolean findTarget(TreeNode root, int k) {
        pushAllLeft(root);
        pushAllRight(root);

        int next = getNext();
        int prev = getPrev();

        while(next < prev){
            int sum = next + prev;
            if(sum == k){
                return true;
            }
            if(sum < k){
                next = getNext();
            }else{
                prev = getPrev();
            }
        }

        return false;
    }
}
