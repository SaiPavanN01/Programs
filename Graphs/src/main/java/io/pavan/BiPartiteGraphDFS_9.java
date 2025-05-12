package io.pavan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://www.geeksforgeeks.org/problems/bipartite-graph/1
public class BiPartiteGraphDFS_9 {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        int[] color = new int[V];
        Arrays.fill(color,-1);
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++)    adjList.add(new ArrayList<>());
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<V;i++){
            if(color[i] == -1){
                if(!dfs(i,0,color,adjList))
                    return false;
            }
        }
        return true;
    }
    public boolean dfs(int node, int col, int[] color,List<List<Integer>> adjList){
        color[node] = col;
        for(int adj : adjList.get(node)){
            if(color[adj] == -1){
                if(!dfs(adj,1-col,color,adjList)) return false;
            }else if(color[adj] == color[node])
                return false;
        }
        return true;
    }
}
