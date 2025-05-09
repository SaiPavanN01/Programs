package io.pavan;

import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/number-of-enclaves/
public class NoOfEnclaves_7 {
    class Node{
        int row;
        int col;
        public Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 || i == m-1 || j == 0 || j == n-1){
                    if(grid[i][j] == 1){
                        vis[i][j] = 1;
                        q.offer(new Node(i,j));
                    }
                }
            }
        }
        int [] delRow = {1,0,-1,0};
        int[] delCol ={0,-1,0,1};
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();
            for(int i=0;i<4;i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];
                if(nRow >= 0 && nRow < m && nCol >= 0 && nCol <n && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                    q.offer(new Node(nRow,nCol));
                    vis[nRow][nCol] = 1;
                }
            }
        }
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1)
                    cnt++;
            }
        }
        return cnt;
    }
}
