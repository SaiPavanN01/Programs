package io.pavan;

public class PrintNto1 {
    public static void main(String[] args) {
        print(5);
    }
//    static void print(int num){
//        if(num==1){
//            System.out.print(num);
//            return;
//        }
//        System.out.print(num+" ");
//        print(num-1);
//    }
    static void print(int num){
        if(num==0){
            return;
        }
        System.out.print(num+" ");
        print(num-1);
        System.out.print(num+" ");
    }
}
