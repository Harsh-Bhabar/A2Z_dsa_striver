package aToZStriverSheetJava._12_Graph;

import java.util.*;

//link - https://leetcode.com/problems/course-schedule/

public class CycleDetect_Directed_KahnsAlgo {

    List<List<Integer>> adj = new ArrayList<>();
    int[] indegree;

    public void getAdjAndIndegree(int[][] prereqs){
        for(int[] nums: prereqs){
            adj.get(nums[1]).add(nums[0]);
            indegree[nums[0]]++;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        getAdjAndIndegree(prerequisites);

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);

            for(int neigh: adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.offer(neigh);
                }
            }
        }

        return ans.size() == numCourses;

    }
}
