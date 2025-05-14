package io.pavan.TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
public class DetectCycleInDirectedGraph_14 {
    boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adjList){
        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for(int adj : adjList.get(i))
                inDegree[adj]++;
        }
        for(int i=0;i<V;i++){
            if(inDegree[i] == 0)
                q.offer(i);
        }
        int cnt =0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            cnt++;
            for(int adj : adjList.get(node)) {
                inDegree[adj]--;
                if (inDegree[adj] == 0)
                    q.offer(adj);
            }
        }
        if(cnt == V)
            return false;
        return true;
    }
}
