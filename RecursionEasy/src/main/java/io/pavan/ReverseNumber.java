package io.pavan;

public class ReverseNumber {
    public static void main(String[] args) {
       reverse1(1234);
        System.out.println(sum);
        System.out.println(reverse2(1243));
    }
    static int sum=0;
    private static void reverse1(int num) {
        if(num == 0)
            return;
        int rem = num %10;
        sum = sum *10 + rem;
        reverse1(num/10);
    }

    private static int reverse2(int num){
        int digits = (int)Math.log10(num)+1;
        return helper(num,digits);
    }
    private static int helper(int num, int digits){
        if(num == 0)
            return 0;
        return (int) (num%10 * Math.pow(10,digits-1) + helper(num/10,digits-1));
    }

}
