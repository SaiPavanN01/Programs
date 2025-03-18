package io.pavan.generics;

import java.util.Arrays;
import java.util.List;

// Here we can pass any Datatype which is sub of Number i.e Integer, Float, long
public class WildCards<T extends Number> {
    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0; // also working as index value

    public WildCards() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];

        // copy the current items in the new array
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public T remove() {
        T removed = (T) (data[--size]);
        return removed;
    }

    public T get(int index) {
        return (T) (data[index]);
    }

    public int size() {
        return size;
    }

    public void set(int index, int value) {
        data[index] = value;
    }
    public void getList(List<Number> list){
        //do something
        // List<Number> here you can only Number type
        // List<? extends Number> here you can Number and subclasses type as well
    }

    @Override
    public String toString() {
        return "elements = " + Arrays.toString(data) ;
    }

    public static void main(String[] args) {
//        ArrayList list = new ArrayList();
        WildCards<Integer> list = new WildCards<>();
//        list.add(3);
//        list.add(5);
//        list.add(9);

        for (int i = 0; i < 14; i++) {
            list.add(2 * i);
        }

        System.out.println(list);

//        ArrayList<Integer> list2 = new ArrayList<>();
//        list2.add("dfghj");
    }
}
