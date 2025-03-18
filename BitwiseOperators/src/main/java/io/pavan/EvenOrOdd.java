package io.pavan;

public class EvenOrOdd {
    public static void main(String[] args) {
        int num=25;
        System.out.println(isOdd(num));
    }
    static boolean isOdd(int num){
        return (num & 1) == 1;
    }
}
