package aToZStriverSheetJava._010_BinaryTree;

import java.util.*;

//link - https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/

public class Time_to_BURN {

    Map<TreeNode, TreeNode> parents = new HashMap<>();

    public TreeNode getParentsAndTarget(TreeNode root, int target){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode ans = null;

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val == target){
                ans = curr;
            }
            if(curr.left != null){
                parents.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right != null){
                parents.put(curr.right, curr);
                q.offer(curr.right);
            }
        }

        return ans;
    }

    public int amountOfTime(TreeNode root, int start) {
        TreeNode target = getParentsAndTarget(root, start);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(target, true);

        int time = 0;

        while(!q.isEmpty()){
            time++;
            int size = q.size();
            while(size-- > 0){
                TreeNode curr = q.poll();

                if(curr.left != null && !visited.containsKey(curr.left)){
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }

                if(curr.right != null && !visited.containsKey(curr.right)){
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }

                if(parents.containsKey(curr) && !visited.containsKey(parents.get(curr))){
                    q.offer(parents.get(curr));
                    visited.put(parents.get(curr), true);
                }
            }
        }

        return time-1;
    }
}
