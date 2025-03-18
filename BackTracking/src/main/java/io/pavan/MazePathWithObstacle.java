package io.pavan;

import java.util.ArrayList;

public class MazePathWithObstacle {
    public static void main(String[] args) {
        boolean[][] arr = {
                {true, true, true},
                {true, false,true},
                {true, true, true},
        };
        pathWithObstacle("",arr,0,0);
        System.out.println(pathWithObstacleRet("",arr,0,0, new ArrayList<>()));
    }

    private static void pathWithObstacle(String p, boolean[][] maze, int row, int col) {
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[row][col])
            return;
        if(row < maze.length-1 ){
            pathWithObstacle(p+"D", maze, row+1, col);
        }
        if(col < maze[0].length-1){
            pathWithObstacle(p+"R", maze, row, col+1);

        }
    }
    private static ArrayList<String> pathWithObstacleRet(String p, boolean[][] maze, int row, int col) {
        if(row == maze.length-1 && col == maze[0].length-1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(!maze[row][col])
            return ans;
        if(row < maze.length-1 ){
            ans.addAll(pathWithObstacleRet(p+"D", maze, row+1, col));
        }
        if(col < maze[0].length-1){
            ans.addAll(pathWithObstacleRet(p+"R", maze, row, col+1));
        }
        return ans;
    }
    private static ArrayList<String> pathWithObstacleRet(String p, boolean[][] maze, int row, int col,ArrayList<String> list) {
        if(row == maze.length-1 && col == maze[0].length-1){
            list.add(p);
            return list;
        }

        if(!maze[row][col])
            return list;
        if(row < maze.length-1 ){
            pathWithObstacleRet(p+"D", maze, row+1, col,list);
        }
        if(col < maze[0].length-1){
            pathWithObstacleRet(p+"R", maze, row, col+1,list);
        }
        return list;
    }

}
