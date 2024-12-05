package aToZStriverSheetJava._010_BinaryTree;

import java.util.*;

public class View_Top {

    static class Pair{
        int vd;
        TreeNode TreeNode;
        Pair(int vd, TreeNode TreeNode){
            this.vd = vd;
            this.TreeNode = TreeNode;
        }
    }

    static ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));
        Map<Integer, Integer> mp = new TreeMap<>();

        while(!q.isEmpty()){
            int n = q.size();
            while(n-- > 0){
                Pair top = q.poll();
                TreeNode curr = top.TreeNode;
                int currVd = top.vd;

                mp.putIfAbsent(currVd, curr.val);

                if(curr.left != null){
                    q.offer(new Pair(currVd-1, curr.left));
                }
                if(curr.right != null){
                    q.offer(new Pair(currVd+1, curr.right));
                }
            }
        }

        for(Map.Entry<Integer, Integer> entry: mp.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;

    }
}
