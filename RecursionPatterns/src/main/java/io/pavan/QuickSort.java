package io.pavan;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={3,8,4,12,7,6};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void sort(int[] arr, int low, int hi){
        if(low>=hi)
            return;
        int start= low;
        int end = hi;
        int mid= start +(end-start)/2;
        int pivot = arr[mid];
        while(start <= end){
            while(arr[start] < pivot)
                start++;
            while(arr[end]>pivot)
                end--;
            if(start <= end){
                swap(arr, start,end);
                start++;
                end--;
            }
        }
        sort(arr, low,end);
        sort(arr, start,hi);
    }
    static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
