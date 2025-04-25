package io.pavan;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr={5,4,3,1,2};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    // For array 1 -> n
    private static void cyclicSort(int[] arr) {
        int i=0;
        while(i< arr.length){
            int correctIndex = arr[i]-1;
            if(arr[i]!=arr[correctIndex]){
                swap(arr,i,correctIndex);
            }
            else{
                i++;
            }
        }
    }
    private static void swap(int[] arr, int start, int end){
//        arr[start] = arr[start]+arr[end];
//        arr[end]=arr[start]-arr[end];
//        arr[start]=arr[start]-arr[end];
        arr[start] = arr[start] ^ arr[end];
        arr[end] = arr[start] ^ arr[end];
        arr[start]= arr[start] ^ arr[end];
    }
}
