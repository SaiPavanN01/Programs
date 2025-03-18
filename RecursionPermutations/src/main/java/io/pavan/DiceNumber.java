package io.pavan;

import java.util.ArrayList;

public class DiceNumber {
    public static void main(String[] args) {
        System.out.println(diceRet("", 5));
//        System.out.println(diceRet("", 4, new ArrayList<>()).size());
        dice("",5);
        System.out.println(diceCount("",5));
        System.out.println(diceRet("", 5).size());
    }
    static void dice(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for (int i = 1; i <=6 && i<= target; i++) {
            dice(p+i, target-i);
        }
    }
    static int diceCount(String p, int target){
        if(target == 0){
            return 1;
        }
        int count =0;
        for (int i = 1; i <= 6 && i<=target ; i++) {
            count+=diceCount(p+i,target-i);
        }
        return count;
    }
    static ArrayList<String> diceRet(String p, int target){
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <=6 && i<= target; i++) {
            ans.addAll(diceRet(p+i, target-i));
        }
        return ans;
    }
    static ArrayList<String> diceRet(String p, int target, ArrayList<String> list){
        if(target == 0){
            list.add(p);
            return list;
        }
        for (int i = 1; i <=6 && i<= target; i++) {
           diceRet(p+i, target-i,list);
        }
        return list;
    }

}
