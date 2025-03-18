package io.pavan;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        List<List<Integer>> lists = subset(arr);
        for (List<Integer> list:lists){
            System.out.println(list);
        }
        List<List<Integer>> lists1 = subsetDuplicate(new int[]{1, 2, 2});
        for (List<Integer> list:lists1)
            System.out.println(list);
    }
    static List<List<Integer>> subset(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num:arr){
            int n= outer.size();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

    static List<List<Integer>> subsetDuplicate(int[] arr){
        List<List<Integer>> outer =new ArrayList<>();
        int start=0;
        int end=0;
        outer.add(new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            start=0;
            int n =outer.size();
            if(i>0 && arr[i]==arr[i-1]){
                start=end+1;
            }
            end= outer.size()-1;
            for (int j = start; j < n; j++) {
                ArrayList<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
