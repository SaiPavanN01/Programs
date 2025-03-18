package io.pavan;

public class DigitProduct {
    public static void main(String[] args) {
        System.out.println(multiple(13456));
    }
    static int multiple(int num){
        if(num==0)
            return 1;
        return (num%10) * multiple(num/10);
    }
}
