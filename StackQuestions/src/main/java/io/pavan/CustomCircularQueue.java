package io.pavan;

public class CustomCircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int front = 0;
    protected int end = 0;
    private int size=0;
    public CustomCircularQueue() {
        this.data = new int[DEFAULT_SIZE];
    }

    public CustomCircularQueue(int size) {
        this.data = new int[size];
    }
    public boolean insert(int item){
        if(isFull()){
            System.out.println("Stack is full, You cannot insert!!");
        }
        data[end++]=item;
        end = end % data.length;
        size++;
        return true;
    }
    public int remove(){
        if(isEmpty()){
            System.out.println("Stack is empty, You cannot remove!!");
            return -1;
        }
        int removed = data[front++];
        front = front % data.length;
        size--;
        return removed;
    }
    public boolean isFull(){
        return size == data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int front(){
        return data[front];
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty, You cannot remove!!");
            return;
        }
        int i=front;
        do{
            System.out.print(data[i++]+" -> ");
            i= i % data.length;
        }while(i!=end);
        System.out.println("END");
    }
}
