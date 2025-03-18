package io.pavan.DLL;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
//        list.insertFirst(12);
//        list.insertFirst(13);
//        list.insertLast(14);
        list.insertLast(12);
        list.insertLast(14);
        list.insertFirst(13);
        list.display();
        list.insertAfter(13, 11);
        list.display();
    }
}
