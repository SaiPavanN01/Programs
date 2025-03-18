package io.pavan;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr={2,4,6,9,11,12,14,18,19};
        int[] arr1={19,18,14,12,11,9,6,4,2};
        int target=14;
        System.out.println(orderAgnosticBS(arr1,target));
    }
    static int orderAgnosticBS(int[] arr, int target){
        int start=0;
        int end=arr.length-1;
        while(arr[start]<arr[end]) {
            int mid = start +(end-start)/2;
            if(arr[mid]==target)
                return mid;
            if(arr[mid]>target)
                end=mid-1;
            if(arr[mid]<target)
                start=mid+1;
        }
        while(arr[start]>arr[end]){
                int mid = start + (end-start)/2;
                if(arr[mid]==target)
                    return mid;
                if(arr[mid]>target)
                    start=mid+1;
                if(arr[mid]<target)
                    end=mid-1;
        }
       return -1;
    }
}
