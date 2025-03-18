public class OrderAgnosticBS {
    public static void main(String[] args) {
        int[] arr={100,95,90,78,76,45,3,2};
        System.out.print(orderAgnosticBS(arr, 45));
    }
    static int orderAgnosticBS(int[] arr, int target){
       int start = 0;
       int end= arr.length-1;
       boolean isAsc = false;
       if(arr[start]<arr[end])
           isAsc=true;
       while(start<=end){
           int mid = start + (end-start)/2;
           if(arr[mid] == target)
               return mid;
           if(isAsc){
               if(arr[mid] > target)
                   end = mid-1;
               if(arr[mid]<target)
                   start = mid+1;
           }else{
               if(arr[mid]>target)
                   start = mid+1;
               if(arr[mid]<target)
                   end = mid-1;
           }
       }
       return -1;
    }
}
