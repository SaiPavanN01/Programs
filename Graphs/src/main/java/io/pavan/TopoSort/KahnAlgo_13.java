package io.pavan.TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnAlgo_13 {
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
        System.out.println();
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adjList){
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++){
            for(int adj : adjList.get(i))
                inDegree[adj]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i] == 0)
                queue.offer(i);
        }
        int[] topo = new int[V];
        int i=0;
        while(!queue.isEmpty()){
            int node = queue.peek();
            queue.remove();
            topo[i++]= node;
            for(int adj : adjList.get(node)){
                inDegree[adj]--;
                if(inDegree[adj] == 0)
                    queue.offer(adj);
            }
        }
        return topo;
    }
}
