package io.pavan;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        permutation("","abc");
        System.out.println(permutationRet("","abc"));
        System.out.println(permutationsCount("","abc",0));
    }
    static void permutation(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            permutation(first + ch+ second,up.substring(1));
        }
    }
    static ArrayList<String> permutationRet(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            list.addAll(permutationRet(first + ch+ second,up.substring(1)));
        }
        return list;
    }
    static int permutationsCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permutationsCount(f + ch + s, up.substring(1));
        }
        return count;
    }
    static int permutationsCount(String p, String up, int count) {
        if (up.isEmpty()) {
            return count + 1;  // Return the incremented count when no characters are left in 'up'
        }
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = permutationsCount(f + ch + s, up.substring(1), count);  // Pass 'count' along
        }
        return count;  // Return the final count after all recursive calls
    }

}
