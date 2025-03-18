import java.util.Arrays;

public class Swap {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,85,76,74,45};
        swap(arr,3,6);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(reverse(arr)));
    }
    static void swap(int[] arr,int index1,int index2){
//        int temp = arr[index1];
//        arr[index1]=arr[index2];
//        arr[index2]=temp;

        // without temp
        arr[index1]=arr[index1]+arr[index2];
        arr[index2]=arr[index1]-arr[index2];
        arr[index1]=arr[index1]-arr[index2];
    }
    static int[] reverse(int[] arr){
        int start=0;
        int end=arr.length-1;
        System.out.println(start+","+end);
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
        return arr;
    }
}
