package io.pavan.exceptionHandling;

public class Main {
    public static void main(String[] args) {
        try{
            throw new MyException("It is my custom exception");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}
