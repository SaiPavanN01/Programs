package io.pavan.cloning;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Human pavan = new Human(25,"Pavan");
        Human keerthi = new Human(26,"Keerthi");
        System.out.println(Arrays.toString(keerthi.arr));
        keerthi.arr[0]=100;
        keerthi.clone();
        System.out.println(Arrays.toString(keerthi.arr));
        System.out.println(Arrays.toString(pavan.arr));
    }
}
