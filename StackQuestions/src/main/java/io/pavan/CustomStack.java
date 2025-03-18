package io.pavan;

public class CustomStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int ptr =-1;
    public CustomStack() {
        this.data=new int[DEFAULT_SIZE];
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }
    public boolean push(int item) throws StackException {
        if(isFull()){
            throw new StackException("Stack is full");
        }
        ptr++;
        data[ptr]=item;
        return true;
    }
    public int pop() throws StackException {
        if(isEmpty()){
            throw new StackException("Cannot pop from an empty stack!!");
        }
        return data[ptr--];
    }
    public int peek() throws StackException {
        if(isEmpty()){
            throw new StackException("Cannot peek from an empty stack!!");
        }
        return data[ptr];
    }
    protected boolean isFull() {
        return ptr == data.length-1;
    }
    protected boolean isEmpty() {
        return ptr == -1;
    }
}
