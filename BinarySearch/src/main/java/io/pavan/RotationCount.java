package io.pavan;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr ={6,7,8,1,2,3,5};
        System.out.println(findRotationCount(arr));
    }
    static int findRotationCount(int[] arr){
        int pivot = findPivotWithDuplicates(arr);
        return pivot+1;
    }
    static int findPivot(int[] arr){
        int start=0;
        int end= arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1])
                return mid;
            if(arr[mid]<arr[mid-1])
                return mid-1;
            if(arr[start]<=arr[mid])
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
    static int findPivotWithDuplicates(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1])
                return mid;
            if(arr[mid]<arr[mid-1])
                return mid-1;
            if(arr[start]==arr[mid] && arr[mid]==arr[end]){
                if(start<mid && arr[start]>arr[start+1]){
                    return start;
                }
                start++;
                if(end>start && arr[end]<arr[end-1]){
                    return end;
                }
                end--;
            }
            if(arr[start]<arr[mid] || arr[start]==arr[mid] && arr[mid]>arr[end])
                start=mid+1;
            else
                end=mid-1;

        }
        return -1;
    }
}
