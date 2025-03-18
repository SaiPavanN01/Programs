package io.pavan.comparing;

public class Main {
    public static void main(String[] args) {
        Student pavan = new Student(77.5f, 25);
        Student rajesh = new Student(88.5f, 24);
        if (pavan.compareTo(rajesh)<0){
            System.out.println("Rajesh have good marks");
        }
    }
}
