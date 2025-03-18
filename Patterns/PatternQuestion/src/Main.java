//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        pattern31(5);
    }

    private static void pattern1(int n) {
        for(int i=0;i<n;i++){
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    private static void pattern2(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    private static void pattern3(int n){
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    private static void pattern4(int n){
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();

        }
    }
    private static void pattern5(int n){
        for (int row = 0; row < 2*n; row++) {
            int totalColsInRow= row>n ?2*n -row :row;
            for (int col = 0; col <totalColsInRow ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    private static void pattern28(int n){
        for (int row = 0; row < 2*n; row++) {
            int totalColsInRow=row>n?2*n-row:row;
            int spaces=n-totalColsInRow;
            for (int space = 0; space < spaces; space++) {
                System.out.print(" ");
            }
            for(int col=0;col<totalColsInRow;col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    private static void pattern30(int n){
        for (int row = 1; row <= n; row++) {
            for (int space = 0; space < n-row; space++) {
                System.out.print("  ");
            }
            for (int col = row; col >=1 ; col--) {
                System.out.print(col+" ");
            }
            for (int col = 2; col <=row ; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    private static void pattern17(int n){
        for (int row = 1; row < 2*n; row++) {
            int c = row > n ? 2 * n - row: row;
            for (int space = 0; space < n-c; space++) {
                System.out.print("  ");
            }
            for (int col = c; col >=1 ; col--) {
                System.out.print(col+" ");
            }
            for (int col = 2; col <=c ; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }
    }
    private static void pattern31(int n){
        int orginalN=n;
        for (int row = 0; row <= 2*n; row++) {
            for (int col = 0; col <=2*n ; col++) {
                int left=col;
                int top=row;
                int right=2*n-col;
                int bottom=2*n-row;
                int atEveryIndex=orginalN-Math.min(Math.min(left,right),Math.min(top,bottom));
                System.out.print(atEveryIndex+" ");
            }
            System.out.println();
        }
    }
}