package io.pavan;

public class LambdaFunctions {
    public static void main(String[] args) {
        Operation sum = (a,b) -> a + b;
        Operation prod = (a,b) -> a * b;
        Operation sub = (a,b) -> a - b;
        LambdaFunctions myCalculator = new LambdaFunctions();

        System.out.println(myCalculator.operate(5,3,sum));
        System.out.println(myCalculator.operate(5,3,prod));
        System.out.println(myCalculator.operate(5,3,sub));
    }
    private int operate(int a, int b, Operation op){
        return op.operate(a,b);
    }
}
interface Operation{
    public int operate(int a, int b);
}
