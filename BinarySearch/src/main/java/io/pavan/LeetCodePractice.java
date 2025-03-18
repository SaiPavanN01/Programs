package io.pavan;

public class LeetCodePractice {
    public static void main(String[] args) {
        int[] arr={2,9,2,2,2,2,2};
        System.out.println(searchInDuplicates(arr,2));
    }
    static int searchInDuplicates(int[] arr,int target){
        int pivot=findPivotWithDuplicates(arr);
        if(pivot==-1)
            return binarySearch(arr,0, arr.length-1,target);
        if(arr[pivot]==target)
            return pivot;
        if(arr[0]<target)
            return binarySearch(arr,0,pivot-1,target);
        return binarySearch(arr,pivot+1,arr.length-1,target);
    }
    static int findPivotWithDuplicates(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(mid<end && arr[mid]>arr[mid+1])
                return mid;
            if(mid<end && arr[mid-1]>arr[mid])
                return mid-1;
            if(arr[start]==arr[mid] && arr[mid]==arr[end]){
                if(start<end && arr[start]>arr[start+1])
                    return start;
                start++;
                if(end>start && arr[end]>arr[end-1])
                    return end;
                end--;
            }
            if(arr[start]<arr[mid] || arr[start]==arr[mid] && arr[mid]>arr[end])
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
    static int binarySearch(int[] arr, int start,int end,int target){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
                return mid;
            if(arr[mid]>target)
                end=mid-1;
            if(arr[mid]<target)
                start=mid+1;
        }
        return -1;
    }
}
