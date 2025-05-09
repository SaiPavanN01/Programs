package io.pavan;

import java.util.ArrayList;
import java.util.HashSet;
// https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
public class NoOfDistinctIslands_8 {
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i,j,vis,grid,i,j,list);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    void dfs(int row,int col,int[][] vis,int[][] grid,int row0,int col0, ArrayList<String> list){

        vis[row][col] = 1;
        list.add((row - row0) + "," + (col - col0));
        int m = grid.length;
        int n = grid[0].length;
        int[] delRow = {1,0,-1,0};
        int[] delCol = {0,-1,0,1};
        for(int i=0;i<4;i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1)
                dfs(nRow,nCol,vis,grid,row0,col0,list);
        }
    }
}
