package io.pavan;

import java.util.*;
// https://www.geeksforgeeks.org/problems/bipartite-graph/1
public class BiPartiteGraphBFS_8 {
    public boolean check(int start, List<List<Integer>> edges, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start]=0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for(int adj : edges.get(node)){
                if(color[adj] == -1){
                    color[adj]= 1 - color[node];
                    q.offer(adj);
                }else if(color[adj] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int V, int[][] edges) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!check(i, adjList, color))
                    return false;
            }
        }
        return true;
    }
}
