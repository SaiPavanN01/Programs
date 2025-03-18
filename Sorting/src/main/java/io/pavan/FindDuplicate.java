package io.pavan;
// https://leetcode.com/problems/find-the-duplicate-number/
public class FindDuplicate {
    public static void main(String[] args) {
        int[] arr ={1,3,4,2,2};
        System.out.println(findDuplicate(arr));
    }

    private static int findDuplicate(int[] arr) {
        int i=0;
        while(i< arr.length){
            int correctIndex=arr[i]-1;
            if(arr[i]!=arr[correctIndex])
                swap(arr,i,correctIndex);
            else
                i++;
        }
        for (int el = 0; el < arr.length; el++) {
            if(arr[el]!=el+1)
                return arr[el];
        }
        return -1;
    }
    static void swap(int[] arr,int start, int end){
        arr[start] = arr[start]+arr[end];
        arr[end]=arr[start]-arr[end];
        arr[start]=arr[start]-arr[end];
    }
}
