package io.pavan;

import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands_2 {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int cnt=0;
        for(int row =0;row<m;row++){
            for(int col=0;col<n;col++){
                if(visited[row][col]== 0 && grid[row][col]=='1'){
                    cnt++;
                    bfs(row,col,visited,grid);
                }
            }
        }
        return cnt;
    }
    private void bfs(int row, int col, int[][] vis,char[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        vis[row][col]=1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row,col));
        // Only 4 directions
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int ro = curr.first;
            int co = curr.second;

            for (int[] dir: directions) {
                int nrow = ro + dir[0];
                int ncol = co + dir[1];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&
                        grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }
    }
    class Pair{
        int first;
        int second;
        public Pair(){}
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
}
