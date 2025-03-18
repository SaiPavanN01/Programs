package io.pavan;

public class PrimeNumber {
    public static void main(String[] args) {
        for (int i=1;i<=20;i++)
            System.out.println(i+" "+isPrime(i));
    }
    static boolean isPrime(int num){
        int c=2;
        if(num<=1)
            return false;
        while(c*c<=num){
            if(num%c==0)
                return false;
            c++;
        }
        return true;
    }
}
