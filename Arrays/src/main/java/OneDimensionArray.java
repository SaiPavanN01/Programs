import java.util.Arrays;
import java.util.Scanner;

public class OneDimensionArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        String[] arr2 = {"a" ,"b", "c", "d"};
        Scanner sc= new Scanner(System.in);
//        //inserting values into array
//        for(int i=0;i<arr1.length;i++)
//            sc.nextInt();
//        for(int i=0;i<arr2.length;i++)
//            sc.next();
        //showing the values
//        for(int i=0;i<arr1.length;i++)
//            System.out.print(arr1[i]+" ");
//        System.out.println();
//
//        for(int i=0;i<arr2.length;i++)
//            System.out.print(arr2[i]+" ");

        // Using enhanced for loop
        for(int arr : arr1)
            System.out.print(arr+" ");
        System.out.println();
        for(String arr:arr2)
            System.out.print(arr+" ");
        System.out.println();
        //Using Arrays.toString()
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
