package io.pavan;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,4,6,8,10,12,15,12};
        System.out.println(findIndex(arr,12));

        System.out.println(findAllIndex(arr, 12, 0));
    }
    static int findIndex(int[] arr, int target){
        return helper(arr, target,0);
    }
    static int helper(int[] arr, int target, int index){
        if(index==arr.length-1)
            return -1;
        return arr[index]==target ? index : helper(arr, target, index+1);
    }
    static List<Integer> findAllIndex(int[] arr, int target, int index, List<Integer> list){
        if(index == arr.length)
            return list;
        if(arr[index] == target)
            list.add(index);
        return findAllIndex(arr, target, index+1, list);
    }

    static List<Integer> findAllIndex(int[] arr, int target, int index){
        List<Integer> list = new ArrayList<>();
        if(index == arr.length)
            return list;
        if(arr[index] == target)
            // this will answer for that particular function call
            list.add(index);
        List<Integer> ansFromBelowCalls = findAllIndex(arr, target, index + 1);
        list.addAll(ansFromBelowCalls);
        return list;
    }
}
