//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class EvenOdd {
    public static void main(String[] args) {
        int n=898;
        System.out.println(isOdd(n));
    }

    private static boolean isOdd(int n) {
        return (n&1)==1;
    }
}