package io.pavan;

public class CeilingNumber {
    //time complexity O[log(n)]
    public static void main(String[] args) {
        int[] arr={2,4,6,9,11,12,14,18,19};
        System.out.println(ceil(arr,16));
    }
    //ceiling : smallest element greater than or equal to target
    static int ceil(int[] arr,int target){
       int start =0;
       int end= arr.length-1;
       while (start <= end){
           int mid = start +(end-start)/2;
           if(arr[mid] ==target)
               return mid;
           if(arr[mid]>target)
               end = mid-1;
           if(arr[mid]<target)
               start= mid+1;
       }
       return start;
    }
}
