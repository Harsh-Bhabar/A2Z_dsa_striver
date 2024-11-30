package aToZStriverSheetJava._008_Heap;

import java.util.*;

//link - https://leetcode.com/problems/find-k-closest-elements/

public class K_ClosestElem {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a,b) -> b[0] != a[0] ? b[0]-a[0] : b[1]-a[1]
        );

        for(int i=0; i<nums.length; i++){
            int diff = Math.abs(nums[i] - x);
            maxHeap.offer(new int[]{diff, nums[i]});

            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            ans.add(maxHeap.poll()[1]);
        }

        Collections.sort(ans);

        return ans;
    }
}
