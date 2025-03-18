package io.pavan;

public class PowerOfTwo {
    public static void main(String[] args) {
        int num=24;
        System.out.println((num & num-1) == 0 ?"Yes":"No");

    }
}
