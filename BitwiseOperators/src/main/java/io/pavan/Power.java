package io.pavan;

public class Power {
    public static void main(String[] args) {
        int base=3;
        int power=7;
        int ans=1;
        while(power>0){
            if((power & 1)==1){
                ans=ans*base;
            }
            power=power>>1;
            base*=base;
        }
        System.out.println(ans);
    }
}
