package io.pavan.cloning;

public class Human implements Cloneable{
    private int age;
    private String name;
    public int[] arr;

    public Human() {

    }

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr= new int[]{2, 3, 56, 7, 9};
    }
    //    Shallow Copy
//    @Override
//    public Human clone() {
//        try {
//            return (Human) super.clone();
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }
    // Deep Copy

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Human twin = (Human)super.clone();
        twin.arr= new int[this.arr.length];
        for (int i = 0; i < twin.arr.length; i++) {
            twin.arr[i]=this.arr[i];
        }
        return twin;
    }
}
