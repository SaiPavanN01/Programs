package io.pavan;

import java.util.ArrayList;
import java.util.List;
// https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
public class DetectCycleInDirectedGraph_10 {
    public boolean isCyclic(int V, int[][] edges) {
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++) adjList.add(new ArrayList<>());
        for(int[] edge : edges)
            adjList.get(edge[0]).add(edge[1]);
        for(int i=0;i<V;i++){
            if(vis[i] == 0)
                if(dfs(i,adjList,vis,pathVis))
                    return true;
        }
        return false;
    }
    public boolean dfs(int node,List<List<Integer>> adjList,int[] vis,int[] pathVis){
        vis[node] = 1;
        pathVis[node] =1;
        for(int adj : adjList.get(node)){
            // when the node is not visited
            if(vis[adj] == 0){
                if(dfs(adj,adjList,vis,pathVis))
                    return true;
            }
            // if the node has been previously visited and
            // but has to be in the same path
            else if(pathVis[adj] == 1)
                return true;
        }
        pathVis[node] = 0;
        return false;
    }
}
