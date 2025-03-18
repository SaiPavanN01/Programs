package io.pavan;

public class FindIthBitOfNumber {
    public static void main(String[] args) {
        int num=182;
        System.out.println(findIthBit(num,5));
    }

    private static int findIthBit(int num,int bit) {
        int maskNumber=1 << bit-1;
        return num & maskNumber;
    }
}
