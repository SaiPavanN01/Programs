package io.pavan;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr ={5,4,3,2,1};
        bubbleSort(arr,arr.length-1,0);
        System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort(int[] arr,int r,int c){
       if(r ==0)
           return;
       if(c<r){
           if(arr[c]>arr[c+1])
               swap(arr, c, c+1);
           bubbleSort(arr, r, c+1);
       }else{
           bubbleSort(arr,r-1,0);
       }
    }
    static void swap(int[] arr, int f,int s){
        int temp=arr[f];
        arr[f]=arr[s];
        arr[s] = temp;
    }
}
