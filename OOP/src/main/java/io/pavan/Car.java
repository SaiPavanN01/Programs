package io.pavan;

public class Car {
    private String engine;
    private long makeYear;

    public Car() {
        System.out.println("Super Constructor is called");
    }
    public Car(String engine, long makeYear){
        this.engine=engine;
        this.makeYear=makeYear;
    }
    public void accelerate(){
        System.out.println("Accelerarting "+engine+" engine!!");
    }
}
