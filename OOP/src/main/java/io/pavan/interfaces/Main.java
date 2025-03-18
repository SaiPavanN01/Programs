package io.pavan.interfaces;

public class Main {
    public static void main(String[] args) {
        NiceCar car = new NiceCar();
        car.start();
        car.stop();
        car.upgradeEngine();
        car.start();
        car.startMusic();
        car.stopMusic();
    }
}
