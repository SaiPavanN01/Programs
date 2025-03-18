package io.pavan;

import java.util.Arrays;
// https://leetcode.com/problems/flipping-an-image/
public class FlipImage {
    public static void main(String[] args) {
        int[][] image={{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(image)));
    }
    static public int[][] flipAndInvertImage(int[][] image) {
//        for (int i = 0; i < image.length; i++) {
//            for(int j=0;j<image[i].length/2;j++){
//                int temp = image[i][j]^1;
//                image[i][j]=image[i][image.length-i-1] ^1;
//                image[i][image.length-1]=temp;
//            }
//        }
        for (int[] row:image){
            for (int i = 0; i < (image[0].length+1)/2; i++) {
                int temp= row[i]^1;
                row[i]=row[image[0].length-i-1]^1;
                row[image[0].length-i-1]=temp;
            }
        }
        return image;
    }
}
