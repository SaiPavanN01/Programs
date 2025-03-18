public class FindUniqueWhenRepeatingOddTimes {
    public static void main(String[] args) {
        int[] arr={2,2,3,4,4,4,2,7,7,7};
        System.out.println(uniqueOdd(arr));
    }

    private static int uniqueOdd(int[] arr) {
        int unique=0;
        for (int j : arr) unique += j;
        System.out.println(unique);
        return unique%3;
    }
}
