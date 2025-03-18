public class FirstAndLastPositionInAnInfiniteArray {
    public static void main(String[] args) {
        int[] arr={3,5,7,89,10,90,100,130,140,160,170};
        System.out.println(search(arr,90));
    }

//    private static int search(int[] arr, int target) {
//        int start=0;
//        int end=1;
//        while(target>arr[end]){
//            int temp= end+1;
//            end=(end-start+1)*2;
//            start=temp;
//        }
//        return binarySearch(arr,target,start,end);
//    }
//
//    private static int binarySearch(int[] arr, int target, int start, int end) {
//        while(start<=end){
//            int mid=start+(end-start)/2;
//            if(target==arr[mid])
//                return mid;
//            else if (target>arr[mid])
//                end=mid-1;
//            else
//                start=mid+1;
//        }
//        return -1;
//    }
    private static int search(int[] arr, int target){
        int start =0;
        int end = 1;
        while(target > arr[end]){
            int temp = end+1;
            end = (end-start+1)*2;
            start= temp;
        }
        return binarySearch(arr, target, start,end);
    }
    private static int binarySearch(int[] arr, int target, int start, int end){
        while(start<= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target)
                return mid;
            if(arr[mid]>target)
                end= mid-1;
            if(arr[mid]<target)
                start=mid+1;
        }
        return -1;
    }
}
