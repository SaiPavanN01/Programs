package io.pavan;

import java.util.Arrays;

// https://leetcode.com/problems/first-missing-positive/
public class MissingPositive {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }

    static int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i]>0 && nums[i] <= nums.length && nums[i] != nums[correctIndex])
                swap(nums,i,correctIndex);
            else
                i++;
        }
        System.out.println(Arrays.toString(nums));
        for (int el = 0; el < nums.length; el++) {
            if (nums[el] != el + 1)
                return el + 1;
        }
        return -1;
    }
        static void swap ( int[] arr, int start, int end){
            arr[start] = arr[start] + arr[end];
            arr[end] = arr[start] - arr[end];
            arr[start] = arr[start] - arr[end];
        }

}
