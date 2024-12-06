package aToZStriverSheetJava._010_BinaryTree;

import java.util.*;

//link - https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

public class Nodes_at_Distance_K {

    public Map<TreeNode, TreeNode> getParents(TreeNode root){
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                parents.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right != null){
                parents.put(curr.right, curr);
                q.offer(curr.right);
            }
        }

        return parents;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parents = getParents(root);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        visited.put(target, true);

        int dist = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()){
            int n = q.size();
            if(dist == k){
                break;
            }
            dist += 1;
            while(n-- > 0){
                TreeNode curr = q.poll();

                if(curr.left != null && !visited.containsKey(curr.left)){
                    visited.put(curr.left, true);
                    q.offer(curr.left);
                }

                if(curr.right != null && !visited.containsKey(curr.right)){
                    visited.put(curr.right, true);
                    q.offer(curr.right);
                }

                if(parents.containsKey(curr) && !visited.containsKey(parents.get(curr))){
                    visited.put(parents.get(curr), true);
                    q.offer(parents.get(curr));
                }
            }
        }

        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }

        return ans;
    }
}
