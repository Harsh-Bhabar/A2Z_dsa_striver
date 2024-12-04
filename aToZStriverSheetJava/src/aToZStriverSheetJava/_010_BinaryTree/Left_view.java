package aToZStriverSheetJava._010_BinaryTree;

import java.util.*;

public class Left_view {
    ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int n = q.size();
            boolean isFirstInLevel = true;

            while(n-- > 0){
                TreeNode curr = q.poll();
                if(isFirstInLevel){
                    isFirstInLevel = false;
                    ans.add(curr.val);
                }
                if(curr.left != null){
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                }
            }
        }

        return ans;
    }
}
