package io.pavan;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces_1 {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        List<List<Integer>> adjLs = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<>());
        }

        // Convert adjacency matrix to adjacency list
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                if (isConnected[i][j] == 1) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        int[] vis = new int[V];
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                cnt++;
                dfs(i, adjLs, vis);
            }
        }
        return cnt;
    }

    private void dfs(int node, List<List<Integer>> adj, int[] visited) {
        visited[node] = 1;
        for (Integer it : adj.get(node)) {
            if (visited[it] == 0) {
                dfs(it, adj, visited);
            }
        }
    }
}
