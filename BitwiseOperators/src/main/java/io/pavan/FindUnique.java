package io.pavan;

public class FindUnique {
    public static void main(String[] args) {
        int[] arr={2,3,4,4,3,2,6};
        System.out.println(findUnique(arr));
    }

    private static int findUnique(int[] arr) {
        int unique=0;
        for(int num:arr){
            unique=unique^num;
        }
        return unique;
    }
}
