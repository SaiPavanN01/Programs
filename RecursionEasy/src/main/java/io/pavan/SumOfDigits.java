package io.pavan;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.print(sum(1342));
    }
    static int sum(int num){
      if(num ==1)
          return 1;
      return num%10+sum(num/10);
    }
}
