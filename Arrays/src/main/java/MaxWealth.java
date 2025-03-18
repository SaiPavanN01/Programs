public class MaxWealth {
    // I
    public static void main(String[] args) {
        int[][] accounts ={
                {1,2,3},
                {4,2,1},
                {5,1,3}
        };
        System.out.println(maximumWealth(accounts));
    }
    static int maximumWealth(int[][] accounts) {
        int wealth=0;
        for (int[] ints : accounts) {
            int sum= 0;
            for (int anInt : ints) {
                sum+=anInt;

            }
            if(wealth<sum)
                wealth=sum;
        }
        return wealth;
    }
}
