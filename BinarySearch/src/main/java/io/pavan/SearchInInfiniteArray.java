package io.pavan;

public class SearchInInfiniteArray {
    public static void main(String[] args) {
        int[] arr ={10,20,24,35,44,47,49,55,59,70,87,98,101,108};
        System.out.println(findTarget(arr,98));
    }

    private static int findTarget(int[] arr, int target) {
        // first start with the box of 2
        int start = 0;
        int end = 1;
        while(target > arr[end]){
            int newStart = end+1;
            end = end + (end-start+1)*2;
            start = newStart;
        }
        return search(arr, target,start,end);
    }
    private static int search(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start+(end-start)/2;
            if(arr[mid] == target)
                return mid;
            if(arr[mid]>target)
                end = mid-1;
            if(arr[mid]<target)
                start=mid+1;
        }
        return -1;
    }
}
