package io.pavan;
// https://leetcode.com/problems/find-in-mountain-array/description/
public class SerachInMountain {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,3,1};
        System.out.println(findInMountainArray(3,arr));
    }
    static int findInMountainArray(int target, int[] arr) {
        int peakEle= peak(arr);
        int first =orderAgnosticBS(arr,0,peakEle,target);
        if(first!=-1)
            return first;
        return orderAgnosticBS(arr,peakEle+1,arr.length-1,target);
    }

    private static int peak(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1])
                end=mid;
            else
                start=mid+1;
        }
        return start;
    }
    private static int orderAgnosticBS(int[] arr, int start,int end,int target){
        boolean isAsc=arr[start]<arr[end];
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
                return mid;
            if(isAsc){
                if(arr[mid]>target)
                    end=mid-1;
                if(arr[mid]<target)
                    start=mid+1;
            }
            else{
                if(arr[mid]>target)
                    start=mid+1;
                if(arr[mid]<target)
                    end=mid-1;
            }
        }
        return -1;
    }
}
