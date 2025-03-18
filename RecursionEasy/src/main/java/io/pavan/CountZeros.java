package io.pavan;

public class CountZeros {
    public static void main(String[] args) {
        System.out.println(countZeroes(30204));
    }

    private static int countZeroes(int num) {
        return helper(num,0);
    }
    private static int helper(int num, int count){
        if(num == 0)
            return count;

        if(num%10==0)
            return helper(num/10,count+1);
        else
            return helper(num/10,count);
    }

}
