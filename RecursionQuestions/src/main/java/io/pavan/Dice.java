package io.pavan;

import java.util.ArrayList;

public class Dice {
    public static void main(String[] args) {
        dice("",4);
        System.out.println(diceRet("",4).size());
        System.out.println(diceCount("",4));
    }

    static void dice(String p, int target){
        if (target==0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <=6 && i <=target ; i++) {
            dice(p+i, target-i);
        }
    }
    static void diceWithCustomFace(String p, int target,int face){
        if (target==0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <=face && i <=target ; i++) {
            diceWithCustomFace(p+i, target-i,face);
        }
    }
    static ArrayList<String> diceRet(String p, int target){
        if (target==0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans= new ArrayList<>();
        for (int i = 1; i <=6 && i <=target ; i++) {
            ans.addAll(diceRet(p+i, target-i));
        }
        return ans;
    }
    static int diceCount(String p, int target){
        if (target==0){
            return 1;
        }
        int count=0;
        for (int i = 1; i <=6 && i <=target ; i++) {
            count+=diceCount(p+i, target-i);
        }
        return count;
    }
}
