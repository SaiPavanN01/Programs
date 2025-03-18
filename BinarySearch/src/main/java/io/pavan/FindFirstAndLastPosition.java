package io.pavan;

import java.util.Arrays;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
public class FindFirstAndLastPosition {
    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,10};
        int target=7;
        System.out.println(Arrays.toString(searchRange(arr,target)));
    }
    static int[] searchRange(int[] arr, int target){
        int[] ans ={-1,-1};
        ans[0]=search(arr,target,true);
        if(ans[0]!=-1)
            ans[1]=search(arr,target,false);
        return ans;
    }
    static int search(int[] arr, int target,boolean firstStartIndex){
        int start=0;
        int end= arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]<target)
                start=mid+1;
            if(arr[mid]>target)
                end=mid-1;
            if(arr[mid]==target){
                ans=mid;
                if(firstStartIndex){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        return ans;
    }

}
