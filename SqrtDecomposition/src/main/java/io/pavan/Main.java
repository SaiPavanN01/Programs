package io.pavan;
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 7, 6, 3, 1, 4, 8};
        int n = arr.length;
        int sqrt = (int) Math.sqrt(n);
        int[] blocks = new int[sqrt+1];
        int blocksId = -1;
        for (int i = 0; i < n; i++) {
            // new block starting
            if(i%sqrt == 0){
                blocksId++;
            }
            blocks[blocksId] += arr[i];
        }
        System.out.println(query( arr, blocks, 2, 7, sqrt));
    }
    public static int query(int[] arr, int[] block, int left, int right, int sqrt){
        int ans = 0;

        // left part
        while(left%sqrt != 0 && left<right && left!=0) {
            ans += arr[left];
            left++;
        }

        // midle part
        while(left + sqrt <= right) {
            ans += block[left/sqrt];
            left += sqrt;
        }

        // right part
        while(left <= right) {
            ans += arr[left];
            left++;
        }

        return ans;
    }
    public static void update(int[] arr, int[] block, int index, int newVal, int sqrt){
        int blocksId = index/sqrt;
        block[blocksId]+= newVal - arr[index];
        arr[index] = newVal;
    }
}
