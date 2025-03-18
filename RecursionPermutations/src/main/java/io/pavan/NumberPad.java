package io.pavan;

import java.util.ArrayList;

public class NumberPad {
    public static void main(String[] args) {
        numberPad("","12");
        System.out.println(numberPadRet("","12", new ArrayList<>()).size());
        System.out.println(numberPadCount("","12",0));
    }
    static void numberPad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        int digit = ch - '0';
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char c = (char) ( 'a' + i);
            numberPad(p+c, up.substring(1));
        }
    }
//    static ArrayList<String> numberPadRet(String p, String up){
//        if(up.isEmpty()){
//            ArrayList<String> list = new ArrayList<>();
//            list.add(p);
//            return list;
//        }
//        ArrayList<String> ans = new ArrayList<>();
//        char ch = up.charAt(0);
//        int digit = ch - '0';
//        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
//            char c = (char) ( 'a' + i);
//            ans.addAll(numberPadRet(p+c, up.substring(1)));
//        }
//        return ans;
//    }
    static ArrayList<String> numberPadRet(String p, String up,ArrayList<String> list){
        if(up.isEmpty()){
           list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';
        for(int i= (digit-1) *3; i< digit *3;i++){
            char ch = (char) ('a'+digit);
            numberPadRet(p+ch, up.substring(1),list);
        }
        return list;
    }
    static int numberPadCount(String p, String up, int count){
       if(up.isEmpty()){
           return count+1;
       }
       int digit =(int)up.charAt(0) - '0';
        for (int i = (digit -1) *3; i < (digit * 3); i++) {
            char ch = (char) ('a'+i);
            count = numberPadCount(p+ch,up.substring(1),count);
        }
        return count;
    }
}
