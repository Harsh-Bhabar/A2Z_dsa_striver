package aToZStriverSheetJava._003_Arrays;

//link - https://leetcode.com/problems/merge-intervals/

import java.util.*;

public class Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n < 2){
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            int[] curr = intervals[i];

            // if curr is outside the intervals, put as it is
            if(ans.isEmpty() || ans.get(ans.size()-1)[1] < curr[0]){
                ans.add(curr);
            }
            // if it is an overlap
            else{
                ans.get(ans.size()-1)[1] =  Math.max(curr[1], ans.get(ans.size()-1)[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
