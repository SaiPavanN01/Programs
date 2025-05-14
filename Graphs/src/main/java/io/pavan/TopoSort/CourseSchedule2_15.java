package io.pavan.TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/course-schedule-ii/
public class CourseSchedule2_15 {
    public int[] findOrder(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++)
            adjList.add(new ArrayList<>());
        int m = prerequisites.length;
        for(int i=0;i<m;i++){
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++){
            for(int adj: adjList.get(i))
                inDegree[adj]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0)
                q.offer(i);
        }
        int[] topo = new int[V];
        int i=0;
        while(!q.isEmpty()){
            int node = q.remove();
            topo[i]=node;
            i++;
            for(int adj : adjList.get(node)){
                inDegree[adj]--;
                if(inDegree[adj]==0){
                    q.offer(adj);
                }
            }
        }
        return i == V ? topo: new int[]{};
    }
}
