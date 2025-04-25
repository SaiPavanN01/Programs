package io.pavan;
// https://leetcode.com/problems/flood-fill/
public class FloodFill_3 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int iniColor = image[sr][sc];
        int[][] ans = image;
        int[] delRow = {1,0,-1,0};
        int[] delCol = {0,-1,0,1};
        dfs(image,ans,sr,sc,iniColor,newColor,delRow,delCol);
        return ans;
    }
    private void dfs(int[][] image, int[][] ans,int sr, int sc, int iniColor,int newColor,int[] delRow,int[] delCol){
        ans[sr][sc]=newColor;
        int m  = ans.length;
        int n = ans[0].length;
        for(int i=0;i<4;i++){
            int nRow = sr + delRow[i];
            int nCol = sc + delCol[i];
            if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && image[nRow][nCol]==iniColor && ans[nRow][nCol]!=newColor)
                dfs(image,ans,nRow,nCol,iniColor,newColor,delRow,delCol);
        }
    }
}
