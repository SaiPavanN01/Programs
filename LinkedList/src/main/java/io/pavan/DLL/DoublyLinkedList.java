package io.pavan.DLL;

public class DoublyLinkedList {
    private Node head;
    private int size;

    public DoublyLinkedList() {
        this.size=0;
    }

    public void insertFirst(int value){
        Node newNode = new Node(value);
        if(head == null ){
            head = newNode;
            head.prev=null;
            size++;
            return;
        }
        newNode.next = head;
        head.prev=newNode;
        head=newNode;
        head.prev=null;
        size++;
    }
    public void insertLast(int val){
        if(head==null){
            Node newNode = new Node(val);
            head=newNode;
            head.prev=null;
            size++;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node newNode = new Node(val);
        newNode.next=null;
        temp.next=newNode;
        newNode.prev=temp;
        size++;

    }
    public void insertAfter(int after, int val){
        Node p = find(after);
        Node newNode = new Node(val);
        newNode.next = p.next;
        newNode.prev=p;
        p.next=newNode;
        if(newNode.next!=null)
            newNode.next.prev=newNode;

    }

    public Node find(int value){
        Node temp = head;
        while(temp!=null){
            if(temp.value == value)
                return temp;
            temp=temp.next;
        }
        return null;
    }
    public void display(){
        Node temp = head;
        Node last = null;
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            last=temp;
            temp=temp.next;
        }
        System.out.println("END");
//        System.out.println("Print in Reverse");
//        while(last!=null){
//            System.out.print(last.value+" -> ");
//            last=last.prev;
//        }
//        System.out.println("START");
    }

    public class Node{
        private int value;
        private Node next;
        private Node prev;

        Node(int value){
            this.value=value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
