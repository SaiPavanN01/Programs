// https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr ={7,2,5,10,8};
        System.out.println(splitArray(arr,2));
    }

    private static int splitArray(int[] arr, int m) {
        int start=0,end=0;
        for (int j : arr) {
            start = Math.max(start, j);
            end+=j;
        }
        while(start<end){
            int mid=start+(end-start)/2;
            int sum=0,pieces=1;
            for(int n:arr){
                if(n+sum>mid){
                    // you cannot add this in this subarray, make new one
                    // say you add this num in new subarray, then sum = num
                    sum = n;
                    pieces++;
                }
                else
                    sum+=n;
            }
            if (pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }
        return end; // here start == end
    }
        
}

