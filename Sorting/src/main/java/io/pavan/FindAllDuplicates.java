package io.pavan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class FindAllDuplicates {
    public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1};
        System.out.println(Arrays.asList(findAllDuplicates(arr)));
    }

    static List<Integer> findAllDuplicates(int[] arr){
        List<Integer> duplicates=new ArrayList<>();
        int i=0;
        while(i< arr.length){
            int correctIndex=arr[i]-1;
            if(arr[i]!=arr[correctIndex])
                swap(arr,i,correctIndex);
            else
                i++;
        }
        for (int el = 0; el < arr.length; el++) {
            if(arr[el]!=el+1)
                duplicates.add(arr[el]);
        }
        return duplicates;
    }
    static void swap(int[] arr,int start, int end){
        arr[start] = arr[start]+arr[end];
        arr[end]=arr[start]-arr[end];
        arr[start]=arr[start]-arr[end];
    }
}
