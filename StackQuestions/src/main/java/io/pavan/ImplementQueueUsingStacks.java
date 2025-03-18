package io.pavan;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        var myQueue = new MyQueue();
        myQueue.push(10);
        myQueue.push(20);
        myQueue.push(30);
        myQueue.push(40);
        myQueue.push(50);
        System.out.println(myQueue.pop());
    }
    static class MyQueue {
        private Stack<Integer> first;
        private Stack<Integer> second;
        public MyQueue() {
            first = new Stack<>();
            second = new Stack<>();
        }

        public void push(int x) {
            first.add(x);
        }
//        public void push(int x){
//            while(!first.isEmpty()){
//                second.push();
//            }
//            first.push(x);
//            while(!second.isEmpty()){
//                first.push(second.pop());
//            }
//        }

        public int pop() {

            while(!first.empty()){
                second.push(first.pop());
            }
            int popped= second.pop();
            while(!second.isEmpty()){
                first.push(second.pop());
            }
            return popped;
        }

        public int peek() {
            while(!first.isEmpty()){
                second.push(first.pop());
            }
            int peeked = second.peek();
            while (!second.isEmpty()) {
                first.push(second.pop());
            }
            return peeked;
        }

        public boolean empty() {
            return first.empty();
        }
    }
}
