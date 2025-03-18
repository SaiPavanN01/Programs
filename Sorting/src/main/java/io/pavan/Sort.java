package io.pavan;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Sort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
//        bubbleSort(arr);
//        selection(arr);
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selection(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int lastIndex = arr.length-i-1;
            int maxIndex =getMaxIndex(arr,0,lastIndex);
            swap(arr,maxIndex,lastIndex);
        }
    }
    private static void swap(int[] arr, int maxIndex, int lastIndex) {
        int temp=arr[maxIndex];
        arr[maxIndex]=arr[lastIndex];
        arr[lastIndex]=temp;
    }

    private static int getMaxIndex(int[] arr, int start, int end) {
        int max=start;
        for (int i=start;i<=end;i++){
            if(arr[max]<arr[i])
                max=i;
        }
        return max;
    }

    static void bubbleSort(int[] arr){
        boolean swapped;
        // run the steps n-1 times
        for (int i = 0; i < arr.length; i++) {
            swapped=false;
            // for each step, max item will come at the last respective index
            for (int j = 1; j < arr.length-i; j++) {
                if(arr[j]<arr[j-1]){
                    arr[j]=arr[j]+arr[j-1];
                    arr[j-1]=arr[j]-arr[j-1];
                    arr[j]=arr[j]-arr[j-1];
                    swapped=true;
                }
            }
            // if you did not swap for a particular value of i, it means the array is sorted hence stop the program
            if(!swapped)
                break;
        }
    }
    static void insertion(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j >0; j--) {
                if(arr[j]<arr[j-1])
                    swap(arr,j,j-1);
                else
                    break;
            }
        }
    }


}