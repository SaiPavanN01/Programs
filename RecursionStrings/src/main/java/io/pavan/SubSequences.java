package io.pavan;

import java.util.ArrayList;

public class SubSequences {
    public static void main(String[] args) {
        String orig="abc";
        subSequence(orig,"");
        System.out.println(subSequenceRet(orig,""));
        System.out.println(subSeqAsciiRet(orig,""));
        subSequenceAscii(orig,"");
    }
    static void subSequence(String orig, String p){
        if(orig.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = orig.charAt(0);
        subSequence(orig.substring(1),p+ch);
        subSequence(orig.substring(1),p);
    }
    static ArrayList<String> subSequenceRet(String orig,String p){
        if (orig.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch=orig.charAt(0);
        ArrayList<String> left = subSequenceRet(orig.substring(1), p + ch);
        ArrayList<String> right = subSequenceRet(orig.substring(1), p);
        left.addAll(right);
        return left;
    }
    static void subSequenceAscii(String orig, String p){
        if(orig.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = orig.charAt(0);
        subSequence(orig.substring(1),p+ch);
        subSequence(orig.substring(1),p);
        subSequence(orig.substring(1),p+(ch+0));
    }
    static ArrayList<String> subSeqAsciiRet(String orig, String p){
        if (orig.isEmpty()){
            ArrayList<String> list =new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = orig.charAt(0);
        ArrayList<String> first = subSeqAsciiRet(orig.substring(1), p);
        ArrayList<String> second =subSeqAsciiRet(orig.substring(1),p+ch);
        ArrayList<String> third =subSeqAsciiRet(orig.substring(1),p+(ch+0));
        first.addAll(second);
        first.addAll(third);
        return first;
    }
}
