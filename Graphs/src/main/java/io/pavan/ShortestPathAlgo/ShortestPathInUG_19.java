package io.pavan.ShortestPathAlgo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInUG_19 {
    public static void main(String[] args) {
        int n=9, m=10;
        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};


        int res[] = shortestPath(edge,n,m,0);
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }
    public static int[] shortestPath(int[][] edges, int N, int M,int src) {
        List<ArrayList<Integer>> adjList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[N];
        for(int i=0;i<N;i++){
            adjList.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<M;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        dist[src] = 0;
        q.offer(0);
        while(!q.isEmpty()){
            int node = q.remove();
            for(int adj : adjList.get(node)){
                if(dist[node]+1 < dist[adj]){
                    dist[adj] = dist[node]+1;
                    q.offer(adj);
                }
            }
        }
        for(int i=0;i<N;i++){
            if(dist[i] == Integer.MAX_VALUE)
                dist[i]=-1;
        }
        return dist;
    }
}
