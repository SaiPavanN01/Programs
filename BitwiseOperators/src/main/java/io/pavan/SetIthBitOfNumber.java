package io.pavan;

public class SetIthBitOfNumber {
    public static void main(String[] args) {
        int num=182;
        System.out.println(setIthBit(num,5));
    }

    private static int setIthBit(int num, int i) {
        int maskNumber=1<<i-1;
        return num | maskNumber;
    }
}
