package aToZStriverSheetJava._12_Graph;

import java.util.*;

//link - https://leetcode.com/problems/course-schedule-ii/

public class Course_schedule_print {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] list: prerequisites){
            adj.get(list[1]).add(list[0]);
            indegree[list[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int[] ans = new int[numCourses];
        int ind = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            ans[ind++] = curr;

            for(int neigh: adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }

        return ind == numCourses ? ans : new int[]{};
    }
}
