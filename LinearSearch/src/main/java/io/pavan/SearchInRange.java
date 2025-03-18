package io.pavan;

public class SearchInRange {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,85,76,74,45};
        System.out.println(searchInRange(arr,1,5,6));
    }
    static int searchInRange(int[] arr, int start, int end,int target){
        if(arr.length==0)
            return -1;
        for(int i=start;i<end;i++){
            if(arr[i]==target)
                return i;
        }
        return -1;
    }
}
