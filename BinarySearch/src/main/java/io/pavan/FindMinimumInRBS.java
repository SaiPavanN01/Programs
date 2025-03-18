package io.pavan;
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInRBS {
    public static void main(String[] args) {
        int[] arr ={6,7,8,1,2,3,5};
        System.out.println(findMin(arr));
    }
    public static int findMin(int[] nums) {
        int pivot = findPivot(nums);
        return nums[pivot+1];
    }
    public static int findPivot(int[] arr){
        int start =0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(mid< end && arr[mid] > arr[mid+1])
                return mid;
            if(mid > start && arr[mid] < arr[mid-1])
                return mid-1;
            if(arr[start] <= arr[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
