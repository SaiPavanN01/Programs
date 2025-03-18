package io.pavan;

public class RBSWithDuplicates {
    public static void main(String[] args) {
        int[] arr={2,9,2,2,2,2,2};
        System.out.println(search(arr,2));
    }
    static int search(int[] arr, int target){
        int pivot=findPivotWithDuplicates(arr);
        if(pivot==-1){
            binarySearch(arr,0,arr.length-1,target);
        }
        if(arr[pivot]==target)
            return pivot;
        if(arr[0]<=target)
            return binarySearch(arr,0,pivot-1,target);
        return binarySearch(arr,pivot+1, arr.length-1, target);

    }

    private static int findPivotWithDuplicates(int[] arr) {
        int start=0;
        int end= arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1])
                return mid;
            if(arr[mid]<arr[mid-1])
                return mid-1;
            if(arr[start]==arr[mid] && arr[mid]==arr[end]){
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if(start<end && arr[start]>arr[start+1])
                    return start;
                start++;
                if(end>start && arr[end]<arr[end-1])
                    return end-1;
                end--;

            }
            //if the left side is sorted so pivot should be in the right
            else if(arr[start]<arr[mid] || arr[start]==arr[mid] && arr[mid]>arr[end])
                start=mid+1;
            // if the right side is sorted so pivoy should be in the left
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
    static int findPivot(int[] arr){
        int start=0;
        int end= arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] > arr[mid+1])
                return mid;
            if(arr[mid-1] > arr[mid])
                return mid-1;
            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                if(start < end && arr[start]>arr[start+1])
                    return start;
                start++;
                if(end > start && arr[end] < arr[end-1])
                    return end-1;
                end--;
            }
            if(arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end])
                start=mid+1;
            else
               end=mid-1;
        }
        return -1;
    }
}
