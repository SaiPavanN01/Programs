package io.pavan.ShortestPathAlgo;

import java.util.ArrayList;
import java.util.Stack;
// https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
public class ShortestPathInDAG_18 {
    class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    private void topoSort(int node, ArrayList<ArrayList<Pair>> adjList, int[] vis, Stack<Integer> st){
        vis[node]=1;
        for(int i=0;i<adjList.get(node).size();i++){
            int v = adjList.get(node).get(i).first;
            if(vis[v] == 0)
                topoSort(v,adjList,vis,st);
        }
        st.push(node);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<Pair>());
        }
        for(int i=0;i<E;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt = edges[i][2];
            adjList.get(u).add(new Pair(v,wt));
        }
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i] == 0)
                topoSort(i,adjList,vis,st);
        }
        int[] dist = new int[V];
        for(int i=0;i<V;i++)
            dist[i] = Integer.MAX_VALUE;
        dist[0] = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            for(int i=0;i<adjList.get(node).size();i++){
                int v = adjList.get(node).get(i).first;
                int wt = adjList.get(node).get(i).second;
                if(dist[node] + wt < dist[v])
                    dist[v] = wt + dist[node];
            }
        }
        return dist;
    }
}
