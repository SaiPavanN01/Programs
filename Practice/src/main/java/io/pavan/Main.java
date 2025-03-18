package io.pavan;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr={2,4,6,9,11,12,14,18,19};
        System.out.println(floor(arr,16));
    }
    static int floor(int[] arr, int target){
        int start=0;
        int end= arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
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