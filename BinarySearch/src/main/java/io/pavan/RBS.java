package io.pavan;
//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class RBS {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,0,1,2};
        System.out.println(search(arr,0));
    }
    static int search(int[] arr,int target){
        int pivot=findPivot(arr);
        if(pivot==-1){
            binarySearch(arr,0,arr.length-1,target);
        }
        if(arr[pivot]==target)
            return pivot;
        if(arr[0]<=target)
            return binarySearch(arr,0,pivot-1,target);
        return binarySearch(arr,pivot+1, arr.length-1, target);


    }
    static int binarySearch(int[] arr,int start,int end,int target){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
                return mid;
            if(arr[mid]<target)
                start=mid+1;
            if(arr[mid]>target)
                end=mid-1;
        }
        return -1;
    }
    static int findPivot(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid<end && arr[mid]>arr[mid+1])
                return mid;
            if(mid<end && arr[mid]<arr[mid-1])
                return mid-1;
            //all elements at right will be lesser than the start, so search in the left part of the array
            if(arr[mid]<=arr[start])
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
}
