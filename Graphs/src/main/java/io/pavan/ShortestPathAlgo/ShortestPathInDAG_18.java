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
    private void topoSort(int node, ArrayList < ArrayList < Pair >> adj,
                          int vis[], Stack < Integer > st) {
        //This is the function to implement Topological sort.

        vis[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).first;
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }
        st.add(node);
    }
    public int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList < ArrayList < Pair >> adj = new ArrayList < > ();
        for (int i = 0; i < N; i++) {
            ArrayList < Pair > temp = new ArrayList < Pair > ();
            adj.add(temp);
        }
        //We create a graph first in the form of an adjacency list.

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }
        int vis[] = new int[N];
        //Now, we perform topo sort using DFS technique
        //and store the result in the stack st.

        Stack < Integer > st = new Stack < > ();
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }
        //Further, we declare a vector ‘dist’ in which we update the value of the nodes’
        //distance from the source vertex after relaxation of a particular node.
        int dist[] = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = (int)(1e9);
        }

        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                if (dist[node] + wt < dist[v]) {
                    dist[v] = wt + dist[node];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }
}
