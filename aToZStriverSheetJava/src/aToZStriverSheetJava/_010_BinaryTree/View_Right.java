package aToZStriverSheetJava._010_BinaryTree;

import java.util.*;
//link - https://leetcode.com/problems/binary-tree-right-side-view/

public class View_Right {
    List<Integer> ans = new ArrayList<>();

    public void solve(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(ans.size() == level){
            ans.add(root.val);
        }
        solve(root.right, level+1);
        solve(root.left, level+1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        solve(root, 0);
        return ans;
    }
}
