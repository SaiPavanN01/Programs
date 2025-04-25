package io.pavan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {

    }
    public List<Integer> bfsOfGraph(int v, List<List<Integer>> adj){
        boolean[] vis = new boolean[v];
        List<Integer> bfs = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
           Integer node = queue.poll();
           bfs.add(node);
           for(Integer it : adj.get(node)){
               if(!vis[it]){
                   vis[it]=true;
                   queue.add(it);
               }
           }
        }
        return bfs;
    }
}
