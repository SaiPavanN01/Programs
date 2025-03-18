public class EvenDigits {
    //https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
    public static void main(String[] args) {
        int[] nums ={12,345,2,6,7896};
        System.out.println(findNumbers(nums));
//        System.out.println(countDigits(4567));
    }
    static int findNumbers(int[] nums){
        int count =0;
        for (int num = 0; num < nums.length; num++) {
            if(evenDigit(nums[num])){
                count++;
            }
        }
        return count;
    }
    static boolean evenDigit(int num){
        return countDigits(num) % 2 == 0;
    }
    static int countDigits(int num){
       int count=0;
       while(num>0){
           num=num/10;
           count++;
       }
       return count;
    }
}
