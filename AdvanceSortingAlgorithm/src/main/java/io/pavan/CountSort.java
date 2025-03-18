package io.pavan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class CountSort {
    public void countSort(int[] arr){
        if(arr == null || arr.length<=1)
            return;
        int max =  arr[0];
        for(int num : arr){
            if(num > max)
                max=num;
        }
        int[] freqArr = new int[max+1];
        for(int num : arr){
            freqArr[num]++;
        }
        int index =0;
        for(int i=0;i<=max;i++){
            while(freqArr[i] > 0){
                arr[index]=i;
                index++;
                freqArr[i]--;
            }
        }
    }
    public void countSortHash(int[] arr){
        if(arr == null || arr.length<=1)
            return;
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int num : arr){
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }
        int index =0;
        for(int i = min;i<=max;i++){
            int count = hashMap.getOrDefault(i,0);
            for(int j=0;j<count;j++){
                arr[index]=i;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr ={6, 3, 10, 9, 2, 4, 9, 7};
        CountSort countSort = new CountSort();
        System.out.println(Arrays.toString(arr));
        countSort.countSortHash(arr);
        System.out.println(Arrays.toString(arr));
    }
}
