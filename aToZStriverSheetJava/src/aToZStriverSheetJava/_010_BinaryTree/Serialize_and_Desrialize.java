package aToZStriverSheetJava._010_BinaryTree;

import java.util.*;

//link - https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

public class Serialize_and_Desrialize {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null){
                return "";
            }

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while(!q.isEmpty()){
                TreeNode curr = q.poll();
                if(curr == null){
                    sb.append("#,");
                    continue;
                }
                sb.append(curr.val + ",");
                q.offer(curr.left);
                q.offer(curr.right);
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data == null || data.isEmpty()){
                return null;
            }

            String[] nodes = data.split(",");

            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            int i = 1;
            while(!q.isEmpty() && i < nodes.length){
                TreeNode curr = q.poll();

                if(!nodes[i].equals("#")){
                    curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                    q.offer(curr.left);
                }
                i++;
                if(i<nodes.length && !nodes[i].equals("#")){
                    curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                    q.offer(curr.right);
                }
                i++;
            }

            return root;
        }
    }

}
