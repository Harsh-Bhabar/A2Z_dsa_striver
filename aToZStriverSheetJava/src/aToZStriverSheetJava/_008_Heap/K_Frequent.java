package aToZStriverSheetJava._008_Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//link - https://leetcode.com/problems/top-k-frequent-elements/

public class K_Frequent {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 1) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );
        for (Map.Entry<Integer, Integer> m : freq.entrySet()) {
            minHeap.offer(new int[]{m.getValue(), m.getKey()});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] ans = new int[k];
        int ind = 0;

        while (!minHeap.isEmpty()) {
            ans[ind++] = minHeap.poll()[1];
        }

        return ans;
    }
}
