public class SetDigits {
    public static void main(String[] args) {
        int num=76;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(setBits(num));
    }

    private static int setBits(int num) {
        int count =0;
        while(num>0){
            num= num & num-1;
            count++;
        }
        return count;
    }
}
