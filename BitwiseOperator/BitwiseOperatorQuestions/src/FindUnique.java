public class FindUnique {
    public static void main(String[] args) {
        int[] arr={2,3,4,3,1,2,4};
        System.out.println(uniqueElement(arr));
    }

    private static int uniqueElement(int[] arr) {
        int unique=0;
        for (int i = 0; i < arr.length; i++) {
            unique^=arr[i];
            System.out.println(unique);
        }
        return unique;
    }
}
