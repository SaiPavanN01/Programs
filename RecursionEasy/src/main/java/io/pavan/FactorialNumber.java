package io.pavan;

public class FactorialNumber {
    public static void main(String[] args) {
        System.out.print(factorial(5));
    }

    private static int factorial(int num) {
        if(num==0)
            return 1;
        return num * factorial(num-1);
    }
}
