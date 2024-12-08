package aToZStriverSheetJava._12_Graph;

import java.util.*;

//link - https://leetcode.com/problems/course-schedule/

public class Course_schedule_check {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] adjList: prerequisites){
            adj.get(adjList[1]).add(adjList[0]);
            indegree[adjList[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int cnt = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            cnt++;
            for(int neigh: adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }

        return cnt == numCourses ? true: false;
    }
}
