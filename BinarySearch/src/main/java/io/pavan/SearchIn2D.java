package io.pavan;

import java.util.Arrays;

public class SearchIn2D {
    public static void main(String[] args) {
        int[][] matrix ={
                {10, 20, 30, 40},
                {15, 25, 35,45},
                {16, 26, 36, 48},
                {18, 28, 39, 50}
        };
        System.out.println(Arrays.toString(search(matrix,39)));
    }
    static int[] search(int[][] matrix,int target){
        int row=0;
        int col=matrix.length-1;
        while(row < matrix.length && col >=0){
            if(matrix[row][col]==target)
                return new int[]{row,col};
            if(matrix[row][col]<target)
                row++;
            if(matrix[row][col]>target)
                col--;
        }
        return new int[]{-1,-1};
    }
}
