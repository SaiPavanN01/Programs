package io.pavan;

public class SumOfNNumbers {
    public static void main(String[] args) {
        System.out.println(sum(6));
    }
    static int sum(int num){
       if(num ==1)
           return 1;
       return num + sum(num-1);
    }
}
