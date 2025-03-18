package io.pavan;

public class FindSetBits {
    public static void main(String[] args) {
        int num=56;
        int count=0;
//        while(num>0){
//            if((num & 1) ==1)
//                count++;
//            num>>=1;
//        }
//        System.out.println(count);
        System.out.println(Integer.toBinaryString(num));
        System.out.println(setBits(num));
    }
    static int setBits(int num){
        int count=0;
        while(num>0){
            num=num & num-1;
            count++;
        }
        return count;
    }
}
