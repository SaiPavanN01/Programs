package io.pavan.inheritance;

public class Main {
    public static void main(String[] args) {
//        BoxWeight boxWeight = new BoxWeight();
//        BoxWeight boxWeight = new BoxWeight(12.9);
        BoxWeight boxWeight = new BoxWeight(3.0, 4.5, 5.5, 12.0);
        System.out.println(boxWeight.l+" "+boxWeight.w+" "+boxWeight.h+" "+boxWeight.weight);
    }
}
