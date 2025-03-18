import java.util.List;

// https://leetcode.com/problems/find-the-duplicate-number/description/
public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }
    public static int findDuplicates(int[] nums) {
        int i=0;
        while(i< nums.length){
            if(nums[i]!=i+1){
                int correctIndex=nums[i] -1;
                if(nums[i]!=nums[correctIndex])
                    swap(nums,i,correctIndex);
                else
                    return nums[i];
            }
            else
                i++;
        }
        return -1;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}
