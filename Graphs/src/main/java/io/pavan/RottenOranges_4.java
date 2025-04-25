package io.pavan;

import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/rotting-oranges/
public class RottenOranges_4 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n =  grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[m][n];
        int cntFresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                }else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1)
                    cntFresh++;
            }
        }
        int tm=0;
        int[] drow={1,0,-1,0};
        int[] dcol={0,-1,0,1};
        int cnt=0;
        while(!q.isEmpty()){
            int r= q.peek().row;
            int c= q.peek().col;
            int time = q.peek().time;
            tm = Math.max(tm,time);
            q.poll();
            for(int i=0;i<4;i++){
                int nRow = r + drow[i];
                int nCol = c + dcol[i];
                if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && grid[nRow][nCol]==1 && vis[nRow][nCol]==0){
                    q.offer(new Pair(nRow,nCol,time+1));
                    vis[nRow][nCol]=1;
                    cnt++;
                }
            }
        }
        if(cnt!=cntFresh) return -1;
        return tm;
    }
    class Pair{
        int row;
        int col;
        int time;
        public Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}
