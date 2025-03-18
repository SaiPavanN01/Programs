package io.pavan.CLL;

public class CircularLinkedList {
    private Node head;
    private Node tail;
    public void insertAtFirst(int val){
        Node newNode = new Node(val);
        if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
        tail.next=newNode;
    }
    public void insert(int val){
        Node newNode = new Node(val);
        if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }
        newNode.next=head;
        tail.next=newNode;
        tail=newNode;
    }
    public int delete(int val){
        Node node = head;
        if(head==null)
            return -1;
        if(head.val == val)
            return val;
        do{
            Node n = node.next;
            if(n.val == val){
                node.next=n.next;
                return val;
            }
            node = node.next;
        }while(node != head);
        return -1;
    }
    public void display(){
        Node temp = head;
        do{
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }while(temp!=head);
        System.out.println();
    }
    public class Node{
        private int val;
        private Node next;

        public Node(int val) {
            this.val=val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
