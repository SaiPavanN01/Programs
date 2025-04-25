package io.pavan;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    List<Integer> dfsOfGraph(int V, List<List<Integer>> adj){
        boolean[] visited = new boolean[V];
        visited[0]=true;
        List<Integer> ls = new ArrayList<>();
        dfs(0,visited,adj,ls);
        return ls;
    }

    private void dfs(int node, boolean[] visited, List<List<Integer>> adj, List<Integer> ls) {
        visited[node]=true;
        ls.add(node);
        for(Integer it:adj.get(node)){
            if(!visited[it]){
                dfs(it,visited,adj,ls);
            }
        }
    }
}
