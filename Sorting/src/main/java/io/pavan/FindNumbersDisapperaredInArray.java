package io.pavan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
public class FindNumbersDisapperaredInArray {
    public static void main(String[] args) {
        int[] arr ={4,3,2,7,8,2,3,1};
        List<Integer> allNumbersDisappeared = findAllNumbersDisappeared(arr);
        System.out.println(Arrays.asList(allNumbersDisappeared));
    }

    private static List<Integer> findAllNumbersDisappeared(int[] arr) {
        int i=0;
        List<Integer> missingNumbers = new ArrayList<>();
        while(i<arr.length){
            int correctIndex=arr[i]-1;
            if(arr[i] < arr.length && arr[i]!=arr[correctIndex])
                swap(arr,i,correctIndex);
            else
                i++;
        }
        for(int j=0;j<arr.length;j++){
            if(j< arr.length-1 && j+1!=arr[j])
                missingNumbers.add(j+1);
        }
        return missingNumbers;
    }
    static void swap(int[] arr,int start, int end){
        arr[start] = arr[start]+arr[end];
        arr[end]=arr[start]-arr[end];
        arr[start]=arr[start]-arr[end];
    }
}
