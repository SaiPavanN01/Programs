package io.pavan;

import java.util.Arrays;
// https://leetcode.com/problems/set-mismatch/
public class SetMismatch {
    public static void main(String[] args) {
        int[] arr={1,1};
        System.out.println(Arrays.toString(findMissingNumber(arr)));
    }

    private static int[] findMissingNumber(int[] arr) {
        int i=0;
        while(i< arr.length){
            int correctIndex=arr[i]-1;
            if(arr[i]!=arr[correctIndex])
                swap(arr,i,correctIndex);
            else
                i++;
        }
        for (int el = 0; el < arr.length; el++) {
            if(el+1!=arr[el])
                return new int[]{arr[el], el + 1};
        }
        return new int[]{-1,-1};
    }
    static void swap(int[] arr,int start, int end){
        arr[start] = arr[start]+arr[end];
        arr[end]=arr[start]-arr[end];
        arr[start]=arr[start]-arr[end];
    }
}
