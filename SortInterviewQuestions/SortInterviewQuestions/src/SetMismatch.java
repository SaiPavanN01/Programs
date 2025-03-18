import java.util.Arrays;

// https://leetcode.com/problems/set-mismatch/
public class SetMismatch {
    public static void main(String[] args) {
        int[] nums={1,2,2,4};
        System.out.println(Arrays.toString(mismatch(nums)));
    }

    private static int[] mismatch(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correctIndex=nums[i]-1;
            if(nums[i]!=nums[correctIndex])
                swap(nums,i,correctIndex);
            else
                i++;
        }
        for (int index = 0; index < nums.length; index++) {
            if(nums[index]!=index+1)
                return new int[]{nums[index],index+1};
        }
        return new int[]{-1,-1};
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
