package io.pavan;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,4,6,8,10,12};
        System.out.println(sorted(arr));
    }
    public static boolean sorted(int[] arr){
        return helper(arr, 0);
    }

    private static boolean helper(int[] arr, int i) {
        if(i == arr.length-1)
            return true;
        return arr[i] < arr[i+1] && helper(arr,i+1);
    }
}
