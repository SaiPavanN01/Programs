package io.pavan;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={3,8,4,12,7,6};
        System.out.println(Arrays.toString(mergeSort(arr)));
        mergeSortInPlace(arr,0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static int[] mergeSort(int[] arr){
        if(arr.length==1)
            return arr;
        int mid= arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right= mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        return merge(left,right);
    }
    static int[] merge(int[] first, int[] second){
        int[] ans= new int[first.length+second.length];
        int i=0;
        int j=0;
        int k=0;
        while(i< first.length && j< second.length){
            if(first[i] < second[j]){
                ans[k]=first[i];
                i++;
            }
            else {
                ans[k]= second[j];
                j++;
            }
            k++;
        }
        while(i< first.length)
        {
            ans[k]= first[i];
            k++;
            i++;
        }
        while(j< second.length)
        {
            ans[k]= second[j];
            k++;
            j++;
        }
        return ans;
    }
    static void mergeSortInPlace(int[] arr, int start, int end){
        if(end-start==1)
            return;
        int mid = (start+end)/2;
        mergeSortInPlace(arr, start,mid);
        mergeSortInPlace(arr,mid,end);

        mergeInPlace(arr, start,mid,end);

    }
    static void mergeInPlace(int[] arr, int start, int mid, int end){
        int[] mix = new int[end - start];

        int i = start;
        int j = mid;
        int k = 0;

        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the arrays is not complete
        // copy the remaining elements
        while (i < mid) {
            mix[k] = arr[i];
            i++;
            k++;
        }

        while (j < end) {
            mix[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[start+l] = mix[l];
        }
    }

}
