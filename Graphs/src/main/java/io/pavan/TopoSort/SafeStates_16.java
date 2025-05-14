package io.pavan.TopoSort;

import java.util.*;

public class SafeStates_16 {
    public List<Integer> eventualSafeNodes(int[][] adjList) {
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        int V = adjList.length;
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++)
            adjRev.add(new ArrayList<>());
        for(int i=0;i<V;i++){
            // i -> adj
            // adj -> i
            for(int adj: adjList[i]){
                adjRev.get(adj).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i] == 0)
                q.offer(i);
        }
        List<Integer> safeNodes = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.remove();
            safeNodes.add(node);
            for(int adj : adjRev.get(node)){
                inDegree[adj]--;
                if(inDegree[adj] == 0)
                    q.offer(adj);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
