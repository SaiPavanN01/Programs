package io.pavan;

public class SkipCharacter {
    public static void main(String[] args) {
        String orig="adadsadsp";
        skip("",orig);
        System.out.println(skipRet("",orig));
        System.out.println(skipRet2(orig));
    }

    private static void skip(String p, String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch == 'a')
            skip(p, up.substring(1));
        else
            skip(p+ch,up.substring(1));
    }
    private static String skipRet(String p, String up){
        if(up.isEmpty())
            return p;
        char ch = up.charAt(0);
        if(ch == 'a')
            return skipRet(p, up.substring(1));
        else
            return skipRet(p+ch,up.substring(1));
    }
    private static String skipRet2(String up){
        if(up.isEmpty())
            return "";
        char ch = up.charAt(0);
        if(ch == 'a')
            return skipRet2(up.substring(1));
        else
            return ch+ skipRet2(up.substring(1));
    }
}
