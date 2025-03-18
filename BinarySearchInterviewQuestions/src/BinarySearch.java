public class BinarySearch
{
    public static void main(String[] args) {
        int[] arr={2,3,45,76,78,90,95,100};
        System.out.println(binarySearch(arr,78));
    }
    static int binarySearch(int[] arr, int target){
        int start =0;
        int end = arr.length-1;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(arr[mid] ==target)
                return mid;
            if(arr[mid]>target)
                end=mid-1;
            if(arr[mid]<target)
                start=mid+1;
        }
        return -1;
    }
}
