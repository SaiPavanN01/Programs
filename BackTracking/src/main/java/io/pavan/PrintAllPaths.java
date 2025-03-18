package io.pavan;

import java.util.Arrays;

public class PrintAllPaths {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true,true},
                {true, true, true},
        };
        int[][] path = new int[maze.length][maze[0].length];
        printAllPaths("", maze, 0,0,path, 1);
    }

    private static void printAllPaths(String p, boolean[][] maze, int row, int col, int[][] path, int step) {
        if(row == maze.length-1 && col == maze[col].length-1){
            path[row][col] = step;
            for (int[] arr: path)
                System.out.println(Arrays.toString(arr));
            System.out.println();
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[row][col])
            return;
        maze[row][col]=false;
        path[row][col] = step;
        if(row < maze.length-1 )
            printAllPaths(p+"D", maze, row+1,col,path,step+1);
        if(col < maze[col].length-1)
            printAllPaths(p+"R", maze,row, col+1,path,step+1);
        if(row >0)
            printAllPaths(p+"U", maze, row-1,col,path,step+1);
        if(col >0)
            printAllPaths(p+"L", maze,row, col-1,path,step+1);
        maze[row][col]=true;
        path[row][col] = 0;
    }
}
