package io.pavan.TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary_17 {
    public static String findOrder(String [] dict, int N, int K) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<K;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(),s2.length());
            for(int ptr =0;ptr<len;ptr++){
                if(s1.charAt(ptr) != s2.charAt(ptr)){
                    adjList.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                    break;
                }
            }
        }
        List<Integer> topo = topoSort(adjList,K);
        String ans="";
        for(int it:topo)
            ans+=(char)(it+(int)'a');
        return ans;
    }
    private static List<Integer> topoSort(ArrayList<ArrayList<Integer>> adjList,int K){
        int[] inDegree = new int[K];
        for(int i=0;i<K;i++){
            for(int adj : adjList.get(i))
                inDegree[adj]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<K;i++){
            if(inDegree[i] == 0)
                q.offer(i);
        }
        List<Integer> topoList = new ArrayList<>();
        while(!q.isEmpty()){
            int node= q.remove();
            topoList.add(node);
            for(int adj : adjList.get(node)){
                inDegree[adj]--;
                if(inDegree[adj]==0)
                    q.offer(adj);
            }
        }
        return topoList;
    }
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};

        String ans = findOrder(dict, N, K);

        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println("");
    }
}
