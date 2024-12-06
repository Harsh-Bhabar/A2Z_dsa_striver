package aToZStriverSheetJava._010_BinaryTree;

import java.util.*;

//link - https://leetcode.com/problems/binary-tree-paths/

public class Print_Paths {
    List<String> ans = new ArrayList<>();

    public void solve(TreeNode root, StringBuilder sb){
        if(root == null){
            return ;
        }

        int length = sb.length();
        sb.append(root.val);

        if(root.left == null && root.right == null){
            ans.add(sb.toString());
        }else{
            sb.append("->");

            solve(root.left, sb);
            solve(root.right, sb);
        }

        sb.setLength(length);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return ans;
        }

        StringBuilder sb = new StringBuilder();
        solve(root, sb);

        return ans;
    }
}
