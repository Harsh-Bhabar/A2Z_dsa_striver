package aToZStriverSheetJava._005_String;

//link - https://leetcode.com/problems/sort-characters-by-frequency/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Sort_Chars_By_Frequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );
        pq.addAll(map.entrySet());

        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> top = pq.poll();
            int freq = top.getValue();
            while(freq-- > 0){
                ans.append(top.getKey());
            }
        }

        return ans.toString();
    }
}
