package io.pavan;
// https://leetcode.com/problems/missing-number/description/
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {3,0,1,2};
        System.out.println(missNumber(arr));
    }
    // For array 0 -> n
    static int missNumber(int[] arr){
        int i=0;
        while(i< arr.length){
            int correctIndex = arr[i];
            if(arr[i]< arr.length-1 && arr[i]!=arr[correctIndex])
                swap(arr,i,correctIndex);
            else {
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]!=j)
                return j;
        }
        return arr.length;
    }
    static void swap(int[] arr, int start, int end){
        arr[start] = arr[start]+arr[end];
        arr[end]=arr[start]-arr[end];
        arr[start]=arr[start]-arr[end];
    }
}
