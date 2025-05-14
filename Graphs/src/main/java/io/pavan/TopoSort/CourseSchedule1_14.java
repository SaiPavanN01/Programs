package io.pavan.TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule/
public class CourseSchedule1_14 {
    public boolean canFinish(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++)
            adjList.add(new ArrayList<>());
        int m = prerequisites.length;
        for(int i=0;i<m;i++)
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++){
            for(int adj : adjList.get(i))
                inDegree[adj]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i] == 0)
                q.offer(i);
        }
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo.add(node);
            for(int adj: adjList.get(node)){
                inDegree[adj]--;
                if(inDegree[adj] == 0)
                    q.offer(adj);
            }
        }
        if(topo.size() == V)
            return true;
        return false;
    }
}
