package io.pavan.TopoSort;

import java.util.ArrayList;
import java.util.List;
// https://www.geeksforgeeks.org/problems/eventual-safe-states/1
public class SafeNodes_11 {
    public boolean dfs(int node, List<List<Integer>> adjList, int[] vis, int[] pathVis, int[] check){
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        for(int adj : adjList.get(node)){
            // when the node is not visited
            if(vis[adj] == 0){
                if(dfs(adj,adjList,vis,pathVis,check)) return true;
            }
            // when the node is visited but
            // it has to be visited on the same path
            else if(pathVis[adj] == 1){
                return true;
            }
        }
        check[node] = 1;
        pathVis[node]=0;
        return false;

    }
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i] == 0)
                dfs(i,adj,vis,pathVis,check);
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i] == 1) safeNodes.add(i);
        }
        return safeNodes;
    }
}
