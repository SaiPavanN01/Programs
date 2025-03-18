package io.pavan.SLL;

public class SingleLinkedList {
    private Node head;
    private Node tail;
    int size;

    public SingleLinkedList() {
        this.size=0;
    }

    public void insertFirst(int value){
        Node newNode = new Node(value);
        newNode.next=head;
        head=newNode;
        if(tail==null){
            tail=head;
        }
        size++;
    }
    public void insertAtPosition(int value, int index){
        if(index==0){
            insertFirst(value);
            return;
        }
        if(index==size-1){
            insert(value);
            return;
        }
        if(index>size+1){
            System.out.println("Please reenter the index between 0 and "+size);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp=temp.next;
        }
        Node newNode= new Node(value, temp.next);
        temp.next=newNode;

        size++;
    }
    public int deleteFirst(){
        Node temp = head;
        int value = head.value;
        head = temp.next;
        size--;
        return value;
    }
    public int deleteLast(){
        if(size<=1)
            return deleteFirst();

        Node secondLast = get(size-2);
        int value = tail.value;
        tail= secondLast;
        tail.next= null;
        size--;
        return value;
    }
    public int deleteAtPos(int index){
        if(index==0)
            return deleteFirst();
        if(index==size-1)
            return deleteLast();
        Node prev = get(index-1);
        int value = prev.next.value;

        prev.next= prev.next.next;
        size--;
        return value;
    }
    public Node get(int index){
        Node node = head;
        for(int i =0; i<index; i++){
            node=node.next;
        }
        return node;
    }
    public Node find(int value){
        Node node = head;
        while(node!=null){
            if(node.value == value){
                return node;
            }
            node=node.next;
        }
        return null;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp=temp.next;
        }
        System.out.println("END");

    }
    public void insert(int value){
        if(tail==null){
            insertFirst(value);
            return;
        }
        Node newNode = new Node(value);
        tail.next=newNode;
        tail=newNode;
        size++;
    }

    private class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value=value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
