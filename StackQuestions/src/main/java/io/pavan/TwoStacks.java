package io.pavan;

import java.util.Arrays;
import java.util.Scanner;


//https://www.hackerrank.com/challenges/game-of-two-stacks/problem
public class TwoStacks {
    public static int twoStacks(int maxSum, int[] a, int[] b) {
        return twoStacks(maxSum,a,b,0,0)-1;
    }
    public static int twoStacks(int maxSum, int[] a, int[] b, int sum, int count){
        if(sum > maxSum)
            return count;
        if(a.length == 0 || b.length ==0)
            return count;
        int ans1 = twoStacks(maxSum,Arrays.copyOfRange(a,1,a.length),b,sum+a[0],count+1);
        int ans2 = twoStacks(maxSum,a,Arrays.copyOfRange(b,1,b.length),sum+b[0],count+1);

        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int t = s.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = s.nextInt();
//            int m = s.nextInt();
//            int x = s.nextInt();
//            int[] a = new int[n];
//            int[] b = new int[m];
//            for (int j = 0; j < n; j++) {
//                a[j] = s.nextInt();
//            }
//            for (int j = 0; j < m; j++) {
//                b[j] = s.nextInt();
//            }
//            System.out.println(twoStacks(x, a, b));
//        }
        int[] a ={4 ,2, 4, 6, 1};
        int[] b ={2,1,8,5};
        System.out.println(twoStacks(10,a,b));
        }

    }
