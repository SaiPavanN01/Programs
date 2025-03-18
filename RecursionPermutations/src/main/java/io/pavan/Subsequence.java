package io.pavan;

import java.util.ArrayList;

public class Subsequence {
    public static void main(String[] args) {
        subSequence("","abc");
        System.out.println(subSequenceRet("","abc").size());
        System.out.println(subSequencesCount("","abc"));
    }

    private static void subSequence(String p, String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subSequence(p+ch, up.substring(1));
        subSequence(p, up.substring(1));
    }
    private static ArrayList<String> subSequenceRet(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subSequenceRet(p+ch,up.substring(1));
        ArrayList<String> right = subSequenceRet(p,up.substring(1));
        left.addAll(right);
        return left;
    }
    private static ArrayList<String> subSequenceRetAscii(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subSequenceRetAscii(p+ch,up.substring(1));
        ArrayList<String> right = subSequenceRetAscii(p+ch,up.substring(1));
        ArrayList<String> ascii = subSequenceRetAscii(p+(ch+0), up.substring(1));
        left.addAll(right);
        left.addAll(ascii);
        return left;
    }
    private static int subSequencesCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        char ch = up.charAt(0);
        int count =0;
        count+=subSequencesCount(p+ch, up.substring(1));
        count+=subSequencesCount(p, up.substring(1));
        return count;
    }
}
