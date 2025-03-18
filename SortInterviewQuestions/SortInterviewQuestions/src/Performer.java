import java.util.Arrays;

public class Performer {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        action(arr,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void action(int[] arr, int n){
        for (int i = 0; i < n; i+=2) {
            if(i+1 < n)
                swap(arr,i,i+1);
        }
    }
    static void swap(int[] arr, int start, int end){
        arr[start] = arr[start]^arr[end];
        arr[end] = arr[start]^arr[end];
        arr[start] = arr[start]^arr[end];
    }
}
