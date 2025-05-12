package io.pavan.TopoSort;

import java.util.ArrayList;
import java.util.Stack;

public class TopoSort_12 {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
    static void dfs(int node,int[] vis,ArrayList<ArrayList<Integer>> adjList,Stack<Integer> stack){
        vis[node]=1;
        for(int adj : adjList.get(node)){
            if(vis[adj] == 0)
                dfs(adj,vis,adjList,stack);
        }
        stack.push(node);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adjList){
        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if(vis[i] == 0)
                dfs(i,vis,adjList,stack);
        }
        int i=0;
        int[] ans = new int[V];
        while(!stack.isEmpty()){
            ans[i++]=stack.peek();
            stack.pop();
        }
        return ans;
    }
}
