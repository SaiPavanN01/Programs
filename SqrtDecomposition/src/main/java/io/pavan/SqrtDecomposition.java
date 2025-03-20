package io.pavan;

public class SqrtDecomposition {
    private int[] arr;
    private int[] blocks;
    private int blockSize;
    public SqrtDecomposition(int[] arr){
        this.arr = arr;
        this.blockSize = (int) Math.sqrt(arr.length);
        this.blocks = new int[(arr.length/blockSize)+1];
        preProcess();
    }
    private void preProcess(){
        for (int i = 0; i < arr.length; i++) {
            blocks[i/blockSize]+=arr[i];
        }
    }
    public int query(int left, int right){
        int sum = 0;
        // Query the partial block from left to the end of the block
        while(left <= right && left % blockSize != 0){
            sum+=arr[left];
            left++;
        }
        // Query the full blocks in between
        while(left+blockSize <= right){
            sum += blocks[left/blockSize];
            left+=blockSize;
        }
        while(left <= right){
            sum+=arr[left];
            left++;
        }
        return sum;
    }
    public void update(int index, int val){
        int blockId = index/blockSize;
        blocks[blockId]+=(val-arr[index]);
        arr[index] = val;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var srd = new SqrtDecomposition(arr);
        System.out.println("Sum of range [2, 8]: " + srd.query(2, 8));
        srd.update(4,10);
        System.out.println("After update Sum of range [2, 8]: " + srd.query(2, 8));
    }
}
