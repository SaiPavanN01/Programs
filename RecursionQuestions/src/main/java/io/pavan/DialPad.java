package io.pavan;

import java.util.ArrayList;
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

public class DialPad {
    public static void main(String[] args) {
        dialPad("","13");
        System.out.println(dialPadRet("", "13"));
        System.out.println(dialPadCount("","12"));
    }
    static void dialPad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digits=up.charAt(0)-'0';
        for (int i = (digits-1)*3; i < digits*3 ; i++) {
            char ch = (char)('a'+i);
            dialPad(p+ch,up.substring(1));
        }
    }

    static ArrayList<String> dialPadRet(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digits=up.charAt(0)-'0';
        ArrayList<String> ans= new ArrayList<>();
        for (int i = (digits-1)*3; i < digits*3 ; i++) {
            char ch = (char)('a'+i);
            ans.addAll(dialPadRet(p + ch, up.substring(1)));
        }
        return ans;
    }
    static int dialPadCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        int digits=up.charAt(0)-'0';
        int count=0;
        for (int i = (digits-1)*3; i < digits*3 ; i++) {
            char ch = (char)('a'+i);
            count+=dialPadCount(p + ch, up.substring(1));
        }
        return count;
    }
// Leet Code Solution
//    public List<String> letterCombinations(String digits) {
//        if(digits.isEmpty())
//            return new ArrayList<>();
//        return dialPadRet("",digits);
//    }
//
//    public ArrayList<String> dialPadRet(String p, String up){
//        if(up.isEmpty()){
//            ArrayList<String> list = new ArrayList<>();
//            list.add(p);
//            return list;
//        }
//        int digits=up.charAt(0)-'1';
//        ArrayList<String> ans= new ArrayList<>();
//        for (int i = (digits-1)*3; i < digits*3 ; i++) {
//            char ch = (char)('a'+i);
//            ans.addAll(dialPadRet(p + ch, up.substring(1)));
//        }
//        return ans;
//    }
}
