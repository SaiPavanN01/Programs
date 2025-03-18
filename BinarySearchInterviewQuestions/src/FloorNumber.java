public class FloorNumber {
    public static void main(String[] args) {
        int[] arr={2,3,5,9,12,14,16,18};
        System.out.println(floor(arr,17));
    }
    //floor: greatest element smaller than or equal to target
    private static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target)
                return mid-1;
            if(arr[mid]<target)
                start = mid+1;
            if(arr[mid]>target)
                end=mid-1;
        }
        return end;
    }
}
