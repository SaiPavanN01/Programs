public class Max {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,85,76,74,45};
        System.out.println(maxElement(arr));
        System.out.println(maxElementRange(arr,2,6));

    }
    static int maxElement(int[] arr){
        int max=arr[0];
        for(int el:arr){
            if(el>max)
                max=el;
        }
        return max;
    }

    static int maxElementRange(int[] arr,int start,int end){
        int max=arr[start];
        for(int i=start;i<=end;i++){
            if(arr[i]>max)
                max=arr[i];
        }
        return max;
    }

}
