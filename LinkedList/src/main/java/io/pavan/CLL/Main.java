package io.pavan.CLL;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insert(13);
        cll.insert(14);
        cll.insertAtFirst(12);
        cll.display();
        cll.delete(14);
        cll.display();
    }
}
