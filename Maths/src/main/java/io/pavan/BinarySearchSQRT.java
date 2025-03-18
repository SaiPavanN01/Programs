package io.pavan;

public class BinarySearchSQRT {
    public static void main(String[] args) {
        int num=45;
        int p=3;
        System.out.println(sqrt(num,p));
    }
    static double sqrt(int num,int p){
        int start=0;
        int end=num;
        double root=0.0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid*mid==num)
                return mid;
            if(mid*mid>num)
                end=mid-1;
            else {
                start = mid + 1;
                root = mid;
            }
        }
        double incr=0.1;
        for (int i = 0; i < p; i++) {
            while(root*root<=num)
                root+=incr;
            root-=incr;
            incr/=10;
        }
        return root;
    }
}
