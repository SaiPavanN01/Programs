import java.util.Arrays;
import java.util.Scanner;

public class TwoDimensionArray {
    public static void main(String[] args) {
//        int[][] arr2D = new int[3][];
        int [][] arr2D={
                {1, 2, 3, 4},
                {5,6},
                {7,8,9}
        };
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter values: ");
//        for (int row=0;row< arr2D.length;row++){
//            for(int col=0;col<arr2D[row].length;col++){
//               arr2D[row][col]= sc.nextInt();
//            }
//        }
        for (int row=0;row< arr2D.length;row++){
            for(int col=0;col<arr2D[row].length;col++){
                System.out.print(arr2D[row][col]+ " ");
            }
            System.out.println();
        }
        //Using Enhanced For Loop
        for(int[] row:arr2D){
            for(int col: row){
                System.out.print(col+" ");
            }
            System.out.println();
        }

        //Using Arrays.toString() method
        for(int[] row:arr2D)
            System.out.println(Arrays.toString(row));
    }
}
