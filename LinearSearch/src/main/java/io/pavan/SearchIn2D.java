package io.pavan;

import java.util.Arrays;

public class SearchIn2D {
    public static void main(String[] args) {
        int [][] arr2D={
                {5,8,9,10,23},
                {25,76,98,67},
                {78,54,32,109,94}
        };
        System.out.println(Arrays.toString(search2D(arr2D,98)));
        System.out.println(max2D(arr2D));
    }
    static int[] search2D(int[][] arr,int target){
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if(arr[row][col]==target) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1,-1};
    }

    static int max2D(int[][] arr){
        int max=0;
        for(int[] row:arr) {
            for (int col : row) {
                if (col > max) {
                    max = col;
                }
            }
        }
        return max;
    }
}
