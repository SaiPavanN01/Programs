package io.pavan;

public class SkipString {
    public static void main(String[] args) {
        String str="apple is my favorite fruit";
        String str1="hdgapplccoi";
        System.out.println(skipApple(str1));
        System.out.println(skipAppNotApple(str1));
    }

    private static String skipApple(String str) {
        if(str.isEmpty())
            return "";
        if(str.startsWith("apple"))
            return skipApple(str.substring(5));
        else
            return str.charAt(0) + skipApple(str.substring(1));
    }
    private static String skipAppNotApple(String str) {
        if(str.isEmpty())
            return "";
        if(str.startsWith("app") && ! str.startsWith("apple"))
            return skipAppNotApple(str.substring(3));
        else
            return str.charAt(0) + skipAppNotApple(str.substring(1));
    }
}
