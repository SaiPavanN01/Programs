package io.pavan.singleton;

import io.pavan.Car;

public class MahindraCar extends Car {
    private String engine;
    private long makeYear;

    public MahindraCar() {
    }
    public MahindraCar(String engine, long makeYear){
        this.engine=engine;
        this.makeYear=makeYear;
    }
    @Override
    public void accelerate() {
        System.out.println("Accelerating "+this.engine+" engine ");
    }

    public static void main(String[] args) {
        Car car = new MahindraCar("Diesel",2024);
        car.accelerate();
    }
}
