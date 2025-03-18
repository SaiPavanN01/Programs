package io.pavan;

public class Static {
    public static void main(String[] args) {
        Human human1 = new Human(14,"human1",15000);
        Human human2 = new Human(15,"human2",15000);
//        System.out.println(Human.population);
        Static st = new Static();
        st.greeting();
        // you cant use this because it requires an instance
//        greeting();
        fun();
    }
    // this is not dependent on objects
    static void fun(){
        System.out.println("For fun");
        //  you cant use this because it requires an instance
        // but the function you are using it in does not depend on instances
//        greeting();
        // you cannot access non static stuff without referencing their instances in
        // a static context

        // hence, here I am referencing it
        Static obj = new Static();
        obj.greeting();
    }

    // we know that something which is not static, belongs to an object
    // this is  dependent on objects
    public void greeting(){
        System.out.println("Hi There!!");
    }

}
class Human{
    int age;
    String name;
    int salary;
    static long population;

    public Human(int age, String name, int salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        Human.population+=1;
    }

    static void greeting(){
        System.out.println("hello");
        // you cannot use this keyword in static method
        //bcz this refers to the current object
       //System.out.println(this.age);
    }
}
