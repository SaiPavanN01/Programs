package io.pavan.ShortestPathAlgo;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class DijkstraAlgo_22 {
    static class Pair {
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    // O(edges * log(V))
    // using priority queue
    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adjList, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int[] dist = new int[V];
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;
        pq.add(new Pair(src, 0));
        dist[src] = 0;
        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int distance = pq.peek().distance;
            pq.poll();
            for (int i = 0; i < adjList.get(node).size(); i++) {
                int edgeWeight = adjList.get(node).get(i).get(1);
                int adjNode = adjList.get(node).get(i).get(0);
                if(distance + edgeWeight < dist[adjNode]){
                    dist[adjNode] = distance + edgeWeight;
                    pq.add(new Pair(adjNode,dist[adjNode]));
                }
            }
        }
        return dist;
    }
    // using set
    static int[] dijkstraSet(int V, ArrayList<ArrayList<ArrayList<Integer>>> adjList, int src){
        TreeSet<Pair> set = new TreeSet<>((x,y) -> x.distance - y.distance);
        int[] dist = new int[V];
        for(int i=0;i<V;i++)
            dist[i] = Integer.MAX_VALUE;
        set.add(new Pair(src,0));
        dist[src] = 0;
        while(!set.isEmpty()){
            Pair current = set.pollFirst();
            int distance = current.distance;
            int node = current.node;
            for(int i=0;i<adjList.get(node).size();i++){
                int edgeWeight = adjList.get(node).get(i).get(1);
                int adjNode = adjList.get(node).get(i).get(0);
                if(edgeWeight + distance < dist[adjNode]){
                    if(dist[adjNode] != Integer.MAX_VALUE)
                        set.remove(new Pair(adjNode,dist[adjNode]));
                    dist[adjNode] = edgeWeight + distance;
                    set.add(new Pair(adjNode,dist[adjNode]));
                }
            }
        }
        return dist;
    }
}
