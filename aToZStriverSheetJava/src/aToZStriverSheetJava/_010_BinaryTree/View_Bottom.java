package aToZStriverSheetJava._010_BinaryTree;

import java.util.*;

public class View_Bottom {

    static class Pair{
        int hd;
        TreeNode TreeNode ;
        Pair(TreeNode TreeNode, int hd){
            this.TreeNode = TreeNode;
            this.hd = hd;
        }
    }

    public ArrayList <Integer> bottomView(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        Map<Integer, Integer> mp = new TreeMap<>();

        while(!q.isEmpty()){
            Pair top = q.poll();
            TreeNode curr = top.TreeNode;
            int hd = top.hd;

            mp.put(hd, curr.val);

            if(curr.left != null){
                q.offer(new Pair(curr.left, hd - 1));
            }
            if(curr.right != null){
                q.offer(new Pair(curr.right, hd + 1));
            }
        }

        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }
}
