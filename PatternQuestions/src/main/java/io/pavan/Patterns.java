package io.pavan;

public class Patterns {
    public static void main(String[] args) {
        // 1. Identify how many lines are there in a pattern, run the outer loop those many
       //  times: no of lines= no of rows = no of times outer loop should run
        // 2. Identify for every row no
        // How many cols are present?
        // 3. What do you need to print?
//        pattern2(5);
//        pattern1(5);
//        pattern3(5);
//        pattern5(5);
//        pattern28(5);
//        pattern30(5);
//        pattern17(5);
        pattern31(3);
    }
    static void pattern1(int n){
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern2(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern3(int n){
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n-row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern4(int n){
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <=row; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    static void pattern5(int n){
        for (int row = 0; row < 2*n; row++) {
            int totalCounts=(row>n)?(2*n-row):row;
            for (int col=0;col<totalCounts;col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern28(int n){
        for (int row = 0; row < 2*n; row++) {
            int totalColsInRow=row>n?(2*n-row):row;
            int totalSpaces=n-totalColsInRow;
            for (int space = 0; space < totalSpaces; space++) {
                System.out.print(" ");
            }
            for (int col = 0; col < totalColsInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    static void pattern30(int n){
        for (int row = 1; row <=n ; row++) {
            int totalSpaces=n-row;
            for (int space = 0; space < totalSpaces; space++) {
                System.out.print("  ");
            }
            for(int col=row;col>=1;col--){
                System.out.print(col+" ");
            }
            for (int col = 2; col <=row ; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
//    static void pattern17(int n){
//        for (int row =1; row <=2*n ; row++) {
//            int totalColsInRow=(row>n)?(2*n-row):row;
//            int totalSpaces=n-row;
//            for (int space = 0; space < totalSpaces; space++) {
//                System.out.print("  ");
//            }
//            for (int col = totalColsInRow; col >= 1; col--) {
//                System.out.print(col+ " ");
//            }
//            for (int col = 2; col <=totalColsInRow ; col++) {
//                System.out.print(col+ " ");
//            }
//            System.out.println();
//        }
//    }
    static void pattern17(int n) {
        for (int row = 1; row <= 2 * n; row++) {

            int c = row > n ? 2 * n - row: row;

            for (int space = 0; space < n-c; space++) {
                System.out.print("  ");
            }

            for (int col = c; col >= 1; col--) {
                System.out.print(col + " ");
            }
            for (int col = 2; col <= c; col++) {
                System.out.print(col + " ");
            }

            System.out.println();
        }
    }
    static void pattern31(int n){
        int originalN=n;
        n=2*n;
        for (int row = 0; row <=n ; row++) {
            for (int col = 0; col <=n ; col++) {
                int num = originalN-Math.min(Math.min(row,col),Math.min(n-row,n-col));
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
