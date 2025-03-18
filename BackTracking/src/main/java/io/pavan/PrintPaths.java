package io.pavan;

import java.util.ArrayList;

public class PrintPaths {
    public static void main(String[] args) {
        mazePath("",3,3);
        System.out.println(mazePathRet("",3,3));
        System.out.println(mazePathDiagnol("",3,3));
    }
    static void mazePath(String p, int row, int col){
        if(row ==1 && col ==1){
            System.out.println(p);
            return;
        }
        if(row >1)
            mazePath(p+'D', row-1,col);
        if(col>1)
            mazePath(p+'R',row, col-1);
    }
    static ArrayList<String> mazePathRet(String p, int row, int col){
        if(row ==1 && col ==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(row >1)
            ans.addAll(mazePathRet(p+'D', row-1,col));
        if(col>1)
            ans.addAll(mazePathRet(p+'R',row, col-1));
        return ans;
    }
    static ArrayList<String> mazePathDiagnol(String p, int row, int col){
        if(row ==1 && col ==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(row > 1)
            ans.addAll(mazePathDiagnol(p+"V",row-1, col));
        if(col>1)
            ans.addAll(mazePathDiagnol(p+"H", row, col-1));
        if(row > 1 && col >1 )
            ans.addAll(mazePathDiagnol(p+"D", row-1, col-1));
        return ans;
    }
}
