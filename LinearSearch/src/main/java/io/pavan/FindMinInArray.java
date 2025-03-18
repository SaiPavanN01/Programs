package io.pavan;

public class FindMinInArray {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,85,76,74,45};
        System.out.println(findMin(arr));
        System.out.println(findMax(arr));
    }

    private static int findMin(int[] arr) {
        if(arr.length==0)
            return -1;
        int min=arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            if(arr[i] < min)
//                min=arr[i];
//        }
        for(int el:arr){
            if(el < min)
                min=el;
        }
        return min;
    }
    private static int findMax(int[] arr) {
        if(arr.length==0)
            return -1;
        int max=arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            if(arr[i] < min)
//                min=arr[i];
//        }
        for(int el:arr){
            if(el > max)
                max=el;
        }
        return max;
    }
}
