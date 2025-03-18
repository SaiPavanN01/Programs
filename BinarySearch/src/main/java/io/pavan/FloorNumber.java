package io.pavan;

public class FloorNumber {
    //time complexity O[log(n)]
    public static void main(String[] args) {
        int[] arr={2,4,6,9,11,12,14,18,19};
        System.out.println(floor(arr,16));
    }
    //floor : greatest element lesser than or equal to target: greatest number <= target
    static int floor(int[] arr, int target){
        int start=0;
        int end=arr.length-1;
        if(target<arr[start])
            return -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==target)
                return mid;
            if(arr[mid]<target)
                start=mid+1;
            if(arr[mid]>target)
                end=mid-1;
        }
        return end;
    }
}
