package aToZStriverSheetJava._010_BinaryTree;

import java.util.*;

//link - https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

public class Traversal_Vertical {

    static class Pair{
        int depth;
        TreeNode node;
        Pair(int depth, TreeNode node){
            this.depth = depth;
            this.node = node;
        }
    }

    Map<Integer, List<Pair>> mp = new TreeMap<>(); // verticalDist , < horiDist , Node >

    public void solve(TreeNode root, int verticalDist, int horizontalDist){
        if(root == null){
            return;
        }
        mp.putIfAbsent(verticalDist, new ArrayList<>());
        mp.get(verticalDist).add(new Pair(horizontalDist, root));

        solve(root.left, verticalDist-1, horizontalDist+1);
        solve(root.right, verticalDist+1, horizontalDist+1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        solve(root, 0, 0);

        for(Map.Entry<Integer, List<Pair>> entry: mp.entrySet()){

            List<Pair> pairs = entry.getValue();
            pairs.sort(
                    (a, b) -> a.depth == b.depth ?
                            Integer.compare(a.node.val, b.node.val) :
                            Integer.compare(a.depth, b.depth)
            );

            List<Integer> temp = new ArrayList<>();
            for(Pair p: pairs){
                temp.add(p.node.val);
            }

            ans.add(temp);
        }

        return ans;
    }
}
