import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BS {
    public static void main(String[] args) {
        int[] arr={1,3,4,5,75,79,90,189};
        System.out.println(search(arr,11,0,arr.length-1));
        List<String> strings = Arrays.asList("apple","banana","mango","grapefruit");
        String maxString = strings.stream().max(Comparator.comparing(String::length)).get();
        System.out.println(maxString);

    }

    private static int search(int[] arr, int target, int start, int end) {
        if(start>end)
            return -1;
        int mid=start+(end-start)/2;
        if(arr[mid]==target)
            return mid;
        else if (arr[mid]>target)
            return search(arr,target,start,mid-1);
        else
            return search(arr,target,mid+1,end);
    }
}
