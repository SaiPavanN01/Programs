package io.pavan.SLL;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SingleLinkedList LL = new SingleLinkedList();
        LL.insert(12);
        LL.insert(13);
        LL.insert(14);
        LL.insert(15);
        LL.insertFirst(11);
        LL.insertAtPosition(100,2);
        LL.deleteFirst();
        LL.display();
        LL.deleteLast();
        LL.display();
        LL.deleteAtPos(2);
        LL.display();
    }
}