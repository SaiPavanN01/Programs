import java.util.Scanner;

public class OneDimensionArray {
    public static void main(String[] args) {
        int[] arr1 = new int[4];
        String[] arr2 = new String[4];
        Scanner sc= new Scanner(System.in);
        //inserting values into array
        for(int i=0;i<arr1.length;i++)
            sc.next();
        for(int i=0;i<arr2.length;i++)
            sc.next();
        //showing the values
        for(int i=0;i<arr1.length;i++)
            System.out.println(arr1[i]);
        for(int i=0;i<arr2.length;i++)
            System.out.println(arr2[i]);

    }
}
