package io.pavan;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student random = new Student();
        System.out.println(random.name);
    }
}
class Student{
    int rollNo;
    String name;
    float marks;

    Student(){
        // this is how you call a constructor
        // from another constructor
        // internally it calls: new Student(12,"Some Random Name",100.0f);
       this(12,"Some Random Name",100.0f);
    }
    Student(int rollNo, String name, float marks){
        this.rollNo=rollNo;
        this.name=name;
        this.marks=marks;
    }
}