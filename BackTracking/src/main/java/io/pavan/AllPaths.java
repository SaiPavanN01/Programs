package io.pavan;

import java.util.ArrayList;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true,true},
                {true, true, true},
        };
//        allPaths("", maze, 0,0);
        System.out.println(allPathsRet("",maze,0,0));
    }

    private static void allPaths(String p, boolean[][] maze, int row, int col) {
        if(row == maze.length-1 && col == maze[col].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[row][col])
            return;
        maze[row][col] = false;
        if(row < maze.length-1 )
            allPaths(p+"D", maze, row+1,col);
        if(col < maze[col].length-1)
            allPaths(p+"R", maze,row, col+1);
        if(row >0)
            allPaths(p+"U", maze, row-1,col);
        if(col >0)
            allPaths(p+"L", maze,row, col-1);

        // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
        maze[row][col]=true;
    }
    private static ArrayList<String> allPathsRet(String p, boolean[][] maze, int row, int col){
        if(row == maze.length-1 && col == maze[0].length-1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(!maze[row][col])
            return ans;
        maze[row][col] = false;
        if(row < maze.length-1)
            ans.addAll(allPathsRet(p+'D',maze,row+1,col));
        if(col < maze.length-1)
           ans.addAll(allPathsRet(p+'R',maze,row,col+1));
        if(row > 0)
            ans.addAll(allPathsRet(p+'U',maze,row-1,col));
        if(col>0)
            ans.addAll(allPathsRet(p+'L',maze,row,col-1));
        if(col < maze[col].length-1 && row < maze.length-1)
            ans.addAll(allPathsRet(p+'d',maze,row+1,col+1));
        maze[row][col]=true;
        return ans;
    }

}
