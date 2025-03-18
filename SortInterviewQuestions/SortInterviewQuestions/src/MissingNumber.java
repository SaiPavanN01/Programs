// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// Asked in Google
public class MissingNumber {
    public static void main(String[] args) {
        int[] arr ={4,2,1,0};
        System.out.println(missingNumberSearch(arr));
    }

    private static int missingNumberSearch(int[] arr) {
        int i=0;
        while(i< arr.length){
            int correctIndex=arr[i];
            if(arr[i]< arr.length && arr[i]!=arr[correctIndex])
                swap(arr,i,correctIndex);
            else
                i++;
        }
        for(int index=0;index< arr.length;index++){
            if(arr[index]!=index)
                return index;
        }
        return arr.length;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
