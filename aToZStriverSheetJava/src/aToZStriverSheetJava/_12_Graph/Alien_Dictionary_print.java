package aToZStriverSheetJava._12_Graph;

import java.util.*;

//link - https://www.geeksforgeeks.org/problems/alien-dictionary/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card

public class Alien_Dictionary_print {

    public String findOrder(String[] dict, int k) {
        int n = dict.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[k];

        for(int i=0; i<n-1; i++){
            char[] s1 = dict[i].toCharArray();
            char[] s2 = dict[i+1].toCharArray();
            int len = Math.min(s1.length, s2.length);

            for(int ptr=0; ptr<len; ptr++){
                if(s1[ptr] != s2[ptr]){
                    int u = s1[ptr]-'a';
                    int v = s2[ptr]-'a';
                    adj.putIfAbsent(u, new ArrayList<>());
                    adj.get(u).add(v);
                    indegree[v]++;
                    break;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<k; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            sb.append((char) (curr + 'a'));
            if(adj.containsKey(curr)){
                for(int neigh: adj.get(curr)){
                    indegree[neigh]--;
                    if(indegree[neigh] == 0){
                        q.offer(neigh);
                    }
                }
            }
        }

        // System.out.println(sb.toString());

        if(sb.length() < k){
            return "";
        }

        return sb.toString();
    }
}
